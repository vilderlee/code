package com.vilderlee.annotation;

/**
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/1/10      Create this file
 * </pre>
 */
@Test public class TestHolder {

    public TestHolder() {
    }

    private String string;

    public TestHolder(String string) {
        this.string = string;
    }

    public void test() {
        System.out.println(string);
    }

    public void setString(String string) {
        this.string = string;
    }
}
