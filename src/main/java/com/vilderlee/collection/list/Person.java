package com.vilderlee.collection.list;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/4/16      Create this file
 * </pre>
 */
public class Person {

    public Person(String id, String name) {
        this.id = id;
        this.name = name;
    }

    private String id;
    private String name;
    private boolean he;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHe() {
        return he;
    }

    public void setHe(boolean he) {
        this.he = he;
    }
}
