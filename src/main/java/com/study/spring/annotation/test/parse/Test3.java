package com.study.spring.annotation.test.parse;

import com.study.spring.annotation.StringAnnotation;

import java.lang.reflect.AnnotatedElement;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/2/27      Create this file
 * </pre>
 */

@StringAnnotation(name = "test3")
public class Test3  {


    public static void main(String[] args) {
        //Class实现了AnnotatedElement接口
        AnnotatedElement annotatedElement = Test3.class;
        StringAnnotation test3 = annotatedElement.getAnnotation(StringAnnotation.class);
        System.out.println(test3.name());

    }
}
