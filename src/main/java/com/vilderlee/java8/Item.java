package com.vilderlee.java8;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/2/13      Create this file
 * </pre>
 */
public class Item {
    private Long amout;
    private String name;

    public Long getAmout() {
        return amout;
    }

    public Item setAmout(Long amout) {
        this.amout = amout;
        return this;
    }

    public String getName() {
        return name;
    }

    public Item setName(String name) {
        this.name = name;
        return this;
    }
}
