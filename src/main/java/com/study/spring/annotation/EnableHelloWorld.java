package com.study.spring.annotation;

import com.study.spring.annotation.test.HelloWorldConfiguration;
import com.study.spring.annotation.test.select.Server;
import com.study.spring.annotation.test.select.ServerImportBeanDefinitionRegistrar;
import com.study.spring.annotation.test.select.ServerImportSelector;
import org.springframework.context.annotation.Import;

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
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({HelloWorldConfiguration.class, ServerImportBeanDefinitionRegistrar.class})
public @interface EnableHelloWorld {

    Server.Type proxy();
}
