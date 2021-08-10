package com.vilderlee.proxy.jdkproxy;

import java.io.*;
import java.lang.reflect.Modifier;

/**
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/1/18      Create this file
 * </pre>
 */
public class Test {

    public static void main(String[] args) {
        try {
            Eat eat = (Eat) ProxyFactory.getInstance(Dog.class);
            eat.eat("肉");

            String proxyName = "$proxy";

            /*
             * Generate the specified proxy class.
             */

            int accessFlags = Modifier.PUBLIC | Modifier.FINAL;
//            byte[] proxyClassFile = ProxyGenerator.generateProxyClass(
//                    proxyName, new Class[]{Eat.class}, accessFlags);
            File file = new File("/Users/vilder/IdeaProjects/code/" + proxyName + ".class");
            Writer writer = new FileWriter(file);
//            IOUtils.write(proxyClassFile, new FileOutputStream(file));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
