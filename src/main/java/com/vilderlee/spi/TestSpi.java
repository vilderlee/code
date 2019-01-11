package com.vilderlee.spi;

import java.util.ServiceLoader;

/**
 *
 * Spi:这里其实考察的是双亲委托模型
 *              BootStrapClassLoader
 *              ExtensionClassLoader
 *              ApplicationClassLoader
 *              自定义ClassLoader
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/1/10      Create this file
 * </pre>
 */
public class TestSpi {

    public static void main(String[] args) {
        ServiceLoader<Say> serviceLoaders = ServiceLoader.load(Say.class);
        for (Say say: serviceLoaders) {
            say.sayHello();
        }
    }
}
