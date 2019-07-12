package com.study.spring.annotation.test.select;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.stream.Stream;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/7/12      Create this file
 * </pre>
 */
public class ServerImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata,
            BeanDefinitionRegistry registry) {
        ServerImportSelector serverImportSelector = new ServerImportSelector();
        String[] classNames = serverImportSelector.selectImports(importingClassMetadata);
        //        for (String clzName: classNames) {
        //            BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(clzName);
        //            AnnotationBeanNameGenerator beanNameGenerator = new AnnotationBeanNameGenerator();
        //            String beanName = beanNameGenerator.generateBeanName(builder.getBeanDefinition(),registry);
        //            registry.registerBeanDefinition(beanName,builder.getBeanDefinition());
        //        }

        Stream.of(classNames).map(BeanDefinitionBuilder::genericBeanDefinition)
                .map(BeanDefinitionBuilder::getBeanDefinition).forEach(
                beanDefinition -> BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinition, registry));
    }
}
