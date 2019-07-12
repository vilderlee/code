package com.vilderlee.spi;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.remoting.Transporter;
import com.alibaba.dubbo.rpc.Protocol;

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
        Protocol transporter = ExtensionLoader.getExtensionLoader(Protocol.class).getAdaptiveExtension();


        Say say1 = ExtensionLoader.getExtensionLoader(Say.class).getAdaptiveExtension();
        URL url = URL.valueOf("test://localhost/test?say=english&hehe=english");
        say1.export(url);
    }
}
