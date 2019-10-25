package com.vilderlee.java8.lambda;

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
    public Item() {
    }

    public Item(String id, Long amout, String name) {
        this.id = id;
        this.amout = amout;
        this.name = name;
    }

    private String id;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
