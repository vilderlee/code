package com.vilderlee.design.observer;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/5/29      Create this file
 * </pre>
 */
public class ObserverB implements Observer {

    @Override
    public void update(String newStatus) {
        System.out.println("B 观察到了新的状态：" + newStatus);
    }
}
