package com.study.component.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/4/17      Create this file
 * </pre>
 */
public abstract class AbstractTx {


    private int i;
    protected List test = new ArrayList();

    public void say(){
        tx1002();
        System.out.println(test.size());
    }

    protected abstract void tx1002();

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}
