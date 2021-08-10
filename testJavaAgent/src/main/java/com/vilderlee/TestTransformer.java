package com.vilderlee;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

/**
 * TestTransformer
 *
 * @ClassName TestTransformer
 * @Description
 * @Author VilderLee
 * @Date 2021/7/31 5:49 下午
 */

public class TestTransformer implements ClassFileTransformer {
    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        System.out.println("Transformer" + className);
        try {
            ClassPool classPool = ClassPool.getDefault();
            CtClass cc = classPool.get("com.vilderlee.proxy.javaagent.Base");

            CtMethod m = cc.getDeclaredMethod("process");
            m.insertBefore("{ System.out.println(\"start\"); }");
            m.insertAfter("{ System.out.println(\"end\"); }");
//            cc.writeFile("/Users/vilder/IdeaProjects/code/src/main/java/com/vilderlee/proxy/javaassist/");

            return cc.toBytecode();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
