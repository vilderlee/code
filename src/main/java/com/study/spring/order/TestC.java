package com.study.spring.order;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/10/23      Create this file
 * </pre>
 */

@Component
@Order(10)
public class TestC implements Test {

    @Override
    public void test() {
        System.out.printf("%s被调用\n", this.getClass().getSimpleName());
    }
}
