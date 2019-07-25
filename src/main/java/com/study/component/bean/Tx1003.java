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
@DespositMode(value = "tx1003", mode = 20)
@Order(2)
public class Tx1003 extends AbstractTx{

    @Override protected void tx1002() {
            System.out.println("This is Tx1003 !!!");
    }
}
