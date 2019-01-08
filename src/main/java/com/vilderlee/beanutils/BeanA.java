package com.vilderlee.beanutils;

import java.util.List;

/**
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/1/8      Create this file
 * </pre>
 */
public class BeanA {
    private String name1;
    private String name2;
    private List<String> nameList;

    public String getName1() {
        return name1;
    }
    public void setName1(String name1) {
        this.name1 = name1;
    }
    public String getName2() {
        return name2;
    }
    public void setName2(String name2) {
        this.name2 = name2;
    }
    public List<String> getNameList() {
        return nameList;
    }
    public void setNameList(List<String> nameList) {
        this.nameList = nameList;
    }
}