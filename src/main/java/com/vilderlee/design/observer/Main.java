package com.vilderlee.design.observer;

import java.util.function.Function;

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
public class Main {
    public static void main(String[] args) {
        Subject subject = new Subject();

        Observer observerA = new ObserverA();
        Observer observerB = new ObserverB();

        subject.attach(observerA);
        subject.attach(observerB);

        subject.notifyAllOberserver("123");

    }
}
