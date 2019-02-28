package com.vilderlee.proxy.javaassist;

import com.vilderlee.proxy.jdkproxy.Eat;
import javassist.ClassPool;
import javassist.CtClass;

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
public class JavassitTest {

    public static void main(String[] args) throws Exception {
        ClassPool classPool = ClassPool.getDefault();

        CtClass ctClass = classPool.get("com.vilderlee.proxy.jdkproxy.Dog");

        Eat eat = (Eat) ctClass.toClass().newInstance();
        eat.eat("肉");
    }
}
