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
public class TestB {

    @Autowired
    private TestA a;

    public void test(){
        System.out.println("B is commit");
        a.test();
    }

}
