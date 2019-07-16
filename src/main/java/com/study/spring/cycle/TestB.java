package com.study.spring.cycle;

import lombok.Data;

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
@Data
public class TestB {

    private TestA a;

    public void test(){
        System.out.println("B is commit");
        a.test();
    }

}
