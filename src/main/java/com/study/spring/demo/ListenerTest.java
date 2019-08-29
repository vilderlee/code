package com.study.spring.demo;

import org.springframework.context.ApplicationListener;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/2/28      Create this file
 * </pre>
 */
public class ListenerTest implements ApplicationListener<ReceiveEmailEvent> {

    @Override
    public void onApplicationEvent(ReceiveEmailEvent event) {

    }
}
