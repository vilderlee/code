package com.vilderlee.spi;

import com.alibaba.dubbo.common.URL;
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
        Say say = extensionLoader.getExtension("chinese");

        say.sayHello();

        Say say1 = ExtensionLoader.getExtensionLoader(Say.class).getAdaptiveExtension();
        URL url = URL.valueOf("test://localhost/test?say=english&hehe=chinese");
        say1.export(url);
    }
}
