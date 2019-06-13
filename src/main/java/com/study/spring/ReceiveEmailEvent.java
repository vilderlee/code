package com.study.spring;

import org.springframework.context.ApplicationEvent;

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
public class ReceiveEmailEvent extends ApplicationEvent {
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public ReceiveEmailEvent(Object source) {
        super(source);
        System.out.println(source);
    }
}
