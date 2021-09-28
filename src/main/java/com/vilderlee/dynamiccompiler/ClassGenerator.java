package com.vilderlee.dynamiccompiler;

import lombok.Getter;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.FileObject;
import javax.tools.ForwardingJavaFileManager;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ClassGenerator
 *
 * @ClassName ClassGenerator
 * @Description
 * @Author VilderLee
 * @Date 2021/9/27 3:18 下午
 */

public class ClassGenerator {

    static File[] files1 = new File[]{};
    File[] files2 = new File[]{};

    public static void main(String[] args) {
        String code =
                "import com.vilderlee.dynamiccompiler.Context;" +
                    "" +
                        "public class Test {" +
                        "    public Context todo(Context context) {" +
                        "        String name = (String) context.get(\"name\");" +
                        "        context.put(\"name\", \"hello\" + name);" +
                        "        context.forEach((k,v) -> {" +
                        "            System.out.println(k);" +
                        "            System.out.println(v);" +
                        "        });" +
                        "        System.out.println(context);" +
                        "        return context;" +
                        "    }" +
                        "}"   ;
                    
        CustomStringJavaCompiler compiler = new CustomStringJavaCompiler(code);

        boolean result = compiler.compiles();
        if (result) {
            System.out.println("编译成功");
            System.out.println("compilerTakeTime:" + compiler.getCompilerTakeTime());
            try {
                compiler.runMainMethod();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("标准输出:" + compiler.getRunResult());
            System.out.println("出参信息：" + compiler.getResult());
            System.out.println("诊断信息:" + compiler.getCompilerMessage());
        } else {
            System.out.println("编译失败");
            System.out.println(compiler.getCompilerMessage());
        }
    }

    @Getter
    private static class CustomStringJavaCompiler {

        //类全名
        private String fullClassName;
        //源码
        private String sourceCode;
        //存放编译之后的字节码
        private Map<String, ByteJavaFileObject> javaFileObjectMap = new ConcurrentHashMap<>();
        //获取Java编译器
        private JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
        //存放编译过程中输出的信息
        private DiagnosticCollector<JavaFileObject> diagnosticCollector = new DiagnosticCollector<>();
        //执行结果
        private String runResult;
        //编译耗时
        private long compilerTakeTime;
        //运行耗时
        private long runTakeTime;

        private Context result;


        public CustomStringJavaCompiler(String sourceCode) {
            this.sourceCode = sourceCode;
            this.fullClassName = getFullClassName(sourceCode);
        }


        /**
         * 编译代码
         *
         * @return
         */
        public boolean compiles() {
            long startTime = System.currentTimeMillis();
            //标准内容管理器
            StandardJavaFileManager standardJavaFileManager = javaCompiler.getStandardFileManager(diagnosticCollector
                    , null, null);
            JavaFileManager fileManager = new StringJavaFileManager(standardJavaFileManager);
            //构建源代码对象
            JavaFileObject javaFileObject = new StringJavaFileObject(fullClassName, sourceCode);
            //获取一个编译任务
            JavaCompiler.CompilationTask task = javaCompiler.getTask(null, fileManager, diagnosticCollector, null, null, Arrays.asList(javaFileObject));
            compilerTakeTime = System.currentTimeMillis() - startTime;

            return task.call();
        }

        public void runMainMethod() throws Exception {
            PrintStream out = System.out;
            try {
                long startTime = System.currentTimeMillis();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                PrintStream printStream = new PrintStream(outputStream);
                System.setOut(printStream);

                StringClassLoader stringClassLoader = new StringClassLoader();

                //流程的数据 ////

                Context context = new Context();
                context.put("name", "lichao");

                Class<?> clz = stringClassLoader.findClass(fullClassName);
                Object o = clz.newInstance();
                Method method = clz.getMethod("todo", Context.class);
//                Object[] pars = new Object[]{1};
//                pars[0] = new String[]{};
                Object result = method.invoke(o, context);

                this.result = (Context) result;

                runTakeTime = System.currentTimeMillis() - startTime;
                runResult = new String(outputStream.toByteArray(), Charset.defaultCharset());
            } finally {
                System.setOut(out);
            }

        }

        /**
         * 获取全类名
         *
         * @param sourceCode
         * @return
         */
        private String getFullClassName(String sourceCode) {
            String className = "";
            Pattern pattern = Pattern.compile("package\\s+\\S+\\s*;");
            Matcher matcher = pattern.matcher(sourceCode);
            if (matcher.find()) {
                className = matcher.group().replaceFirst("package", "").replace(";", "").trim() + ".";
            }

            pattern = Pattern.compile("class\\s+\\S+\\s+\\{");
            matcher = pattern.matcher(sourceCode);
            if (matcher.find()) {
                className += matcher.group().replaceFirst("class", "").replace("{", "").trim();
            }
            return className;
        }


        public long getCompilerTakeTime() {
            return compilerTakeTime;
        }

        public String getRunResult() {
            return runResult;
        }

        /**
         * 编译信息
         *
         * @return
         */
        public String getCompilerMessage() {
            StringBuilder stringBuilder = new StringBuilder();
            List<Diagnostic<? extends JavaFileObject>> diagnosticList = diagnosticCollector.getDiagnostics();
            for (Diagnostic diagnostic : diagnosticList) {
                stringBuilder.append(diagnostic.toString()).append("\r");
            }
            return stringBuilder.toString();
        }


        private class StringJavaFileManager extends ForwardingJavaFileManager {
            public StringJavaFileManager(StandardJavaFileManager standardJavaFileManager) {
                super(standardJavaFileManager);
            }

            //
            @Override
            public JavaFileObject getJavaFileForOutput(Location location, String className, JavaFileObject.Kind kind, FileObject sibling) throws IOException {
                ByteJavaFileObject javaFileObject = new ByteJavaFileObject(className, kind);
                javaFileObjectMap.put(className, javaFileObject);
                return javaFileObject;
            }


        }

        private class ByteJavaFileObject extends SimpleJavaFileObject {

            public ByteJavaFileObject(String className, JavaFileObject.Kind kind) {
                super(URI.create("string:///" + className.replaceAll("\\.", "/") + Kind.SOURCE.extension), kind);
            }

            public ByteArrayOutputStream out;

            @Override
            public OutputStream openOutputStream() throws IOException {
                out = new ByteArrayOutputStream();
                return out;
            }

            public byte[] getCompiledBytes() {
                return out.toByteArray();
            }
        }

        private class StringJavaFileObject extends SimpleJavaFileObject {

            public StringJavaFileObject(String className, String sourceCode) {
                super(URI.create("string:///" + className.replaceAll("\\.", "/") + Kind.SOURCE.extension), Kind.SOURCE);
                this.sourceCode = sourceCode;
            }

            private String sourceCode;

            @Override
            public CharSequence getCharContent(boolean ignoreEncodingErrors) throws IOException {
                return sourceCode;
            }
        }

        private class StringClassLoader extends ClassLoader {

            @Override
            protected Class<?> findClass(String name) throws ClassNotFoundException {
                ByteJavaFileObject fileObject = javaFileObjectMap.get(name);
                if (fileObject != null) {
                    byte[] bytes = fileObject.getCompiledBytes();
                    return defineClass(name, bytes, 0, bytes.length);
                }
                try {
                    return ClassLoader.getSystemClassLoader().loadClass(name);
                } catch (Exception e) {
                    return super.findClass(name);
                }
            }
        }
    }
}
