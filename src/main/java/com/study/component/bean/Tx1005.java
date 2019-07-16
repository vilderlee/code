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
@DespositMode(mode = 10)@Order(1)
public class Tx1005 extends AbstractTx1{


    @Override protected void tx1002() {
        System.out.println("This is Tx1005 !!!");
    }
}
