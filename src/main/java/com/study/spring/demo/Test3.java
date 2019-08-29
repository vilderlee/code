package com.study.spring.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

@Component
public class Test3  {
    @Autowired
    private Test2 test2;

    public void test(){
        test2.test2();
    }

}
