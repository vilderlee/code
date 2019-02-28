package com.vilderlee.proxy.javaassist;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

import java.io.IOException;

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
    public static void main(String[] args) throws CannotCompileException, IOException {
        ClassPool classPool = ClassPool.getDefault();

        //创建类名
        CtClass clz = classPool.makeClass("com.vilderlee.JavassistTest");
        //创建方法
        CtMethod method = CtMethod.make("public void test(String str1, String str2){}", clz);
        method.insertBefore("System.out.println($1);");

//        method.insertAfter("System.out.println($2);");
        clz.addMethod(method);

        clz.writeFile("D://temp");
    }
}
