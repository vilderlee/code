package com.study.spring.cycle;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/7/15      Create this file
 * </pre>
 */
@Component
public class TestA {

    @Autowired
    private TestB b;

    public void test(){
        System.out.println("A is commit");
        b.test();
    }
}
