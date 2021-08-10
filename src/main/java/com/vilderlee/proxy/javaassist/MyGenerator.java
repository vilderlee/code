package com.vilderlee.proxy.javaassist;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

import java.lang.reflect.Method;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/2/25      Create this file
 * </pre>
 */
public class MyGenerator {
    public static void main(String[] args) throws Exception {
        ClassPool classPool = ClassPool.getDefault();

        //创建类名
        CtClass clz = classPool.get("com.vilderlee.proxy.javaassist.JavassitTest");
        //创建方法
//        CtMethod method = CtMethod.make("public void test(String str1, String str2){}", clz);

        CtClass[] paramTypes = new CtClass[]{classPool.get("java.lang.String"), classPool.get("java.lang.String")};
        CtMethod method = clz.getDeclaredMethod("process", paramTypes);
        method.insertBefore("System.out.println($1);");

        method.insertAfter("System.out.println($2);");
//        clz.addMethod(method);
        clz.writeFile("/Users/vilder/IdeaProjects/code/src/main/java/com/vilderlee/proxy/javaassist/");
        final Class<?> aClass = clz.toClass();
        final JavassitTest o = (JavassitTest) aClass.newInstance();
        final Method test = aClass.getDeclaredMethod("process", String.class, String.class);
        test.invoke(o, "vilderlee", "123");
    }
}
