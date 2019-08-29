package com.study.spring.aop.annotation.aspectj;

import org.springframework.stereotype.Component;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/7/24      Create this file
 * </pre>
 */
@Component
public class CircleServiceImpl {


    public void draw(){
        System.out.println("Draw a Circle!");
    }
}
