package com.study.spring.scanner;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import java.util.stream.Stream;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/7/16      Create this file
 * </pre>
 */
public class ClassPathScannerTest {

    public static void main(String[] args) {

        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(factory);
//        scanner.addExcludeFilter(new AnnotationTypeFilter(ModifyComponent.class));
        scanner.addIncludeFilter(new AnnotationTypeFilter(ModifyComponent.class));
        scanner.scan("com.study.spring.scanner");


        String[] names = factory.getBeanDefinitionNames();
        Stream.of(names).forEach(System.out::println);

    }
}
