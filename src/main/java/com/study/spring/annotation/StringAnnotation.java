package com.study.spring.annotation;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/6/17      Create this file
 * </pre>
 */

@Target(ElementType.TYPE)
@Component
@Documented
@Transactional
@Retention(RetentionPolicy.RUNTIME)
public @interface StringAnnotation {
    String name();
}
