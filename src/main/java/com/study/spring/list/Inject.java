package com.study.spring.list;

import org.springframework.stereotype.Component;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/8/27      Create this file
 * </pre>
 */
@Component
public class Inject {

    public void inject(){
        System.out.println("Inject.class");
    }
}
