package com.vilderlee.spi;

import com.alibaba.dubbo.common.URL;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/7/1      Create this file
 * </pre>
 */
public class SayWarpper implements Say {

    private Say say;

    public SayWarpper(Say say) {
        this.say = say;
    }

    @Override public void sayHello() {
        say.sayHello();
    }

    @Override public void export(URL url) {
        System.out.println("this is SayWarpper export");
        say.export(url);
    }
}
