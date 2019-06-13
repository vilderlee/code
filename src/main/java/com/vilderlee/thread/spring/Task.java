package com.vilderlee.thread.spring;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/5/7      Create this file
 * </pre>
 */
public class Task {
    private String name;
    private int num;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override public String toString() {
        return "Task{" + "name='" + name + '\'' + ", num=" + num + '}';
    }
}
