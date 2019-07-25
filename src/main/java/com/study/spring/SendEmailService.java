package com.study.spring;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;

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
public class SendEmailService implements ApplicationEventPublisher {
    @Override
    public void publishEvent(Object event) {
    }
}
