package com.study.compant.bean;

import com.study.compant.DespositMode;

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
public class Tx1003 {
    public void tx1003(){
        System.out.println("This is Tx1001 !!!");
    }
}
