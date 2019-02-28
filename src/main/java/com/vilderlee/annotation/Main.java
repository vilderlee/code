package com.vilderlee.annotation;

import java.lang.annotation.Annotation;

/**
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/1/10      Create this file
 * </pre>
 */
public class Main {
    public static void main(String[] args) {
        Annotation annotation = TestHolder.class.getAnnotation(Test.class);
        System.out.println(annotation.annotationType() == Test.class);
    }
}
