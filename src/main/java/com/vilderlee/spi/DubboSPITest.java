package com.vilderlee.spi;

import com.alibaba.dubbo.common.extension.ExtensionLoader;

/**
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/1/10      Create this file
 * </pre>
 */
public class DubboSPITest {
    public static void main(String[] args) {
        ExtensionLoader<Say> extensionLoader = ExtensionLoader.getExtensionLoader(Say.class);
        Say chinese = extensionLoader.getExtension("chinese");
        chinese.sayHello();
        Say english = extensionLoader.getExtension("english");
        english.sayHello();
    }
}
