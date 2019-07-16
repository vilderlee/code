package com.study.component.bean;

import com.study.component.DespositMode;
import org.springframework.core.annotation.Order;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/4/12      Create this file
 * </pre>
 */
@DespositMode(value = "tx1001", mode = 10)
@Order(1)
public class Tx1001 extends AbstractTx{


    @Override protected void tx1002() {
        System.out.println("This is Tx1001 !!!");
    }
}
