package com.vilderlee.design.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 类说明:
 * 被观察者
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/5/29      Create this file
 * </pre>
 */
public class Subject {
    /**
     * 保存注册的观察者对象
     */
    private List<Observer> list = new ArrayList<>();

    /**
     * 注册
     * @param observer
     */
    public void attach(Observer observer) {
        list.add(observer);
    }

    /**
     * 注销
     * @param observer
     */
    public void detach(Observer observer) {
        list.remove(observer);
    }

    /**
     * 通知
     *
     * @param newStatus
     */
    public void notifyAllOberserver(String newStatus) {
        list.forEach(observer -> observer.update(newStatus));
    }
}
