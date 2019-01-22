package com.vilderlee.enumation;

/**
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/1/21      Create this file
 * </pre>
 */
public enum TestEnum {

    PERSON("p", "Person"), DOG("d", "Dog");

    private String chinese;
    private String english;

    TestEnum(String chinese, String english) {
        this.chinese = chinese;
        this.english = english;
    }

    public static TestEnum getEnum(String chinese) {
        for (TestEnum testEnum : TestEnum.values()) {
            if (testEnum.getChinese().equals(chinese)) {
                return testEnum;
            }
        }
        return null;
    }

    public String getChinese() {
        return chinese;
    }

    public void setChinese(String chinese) {
        this.chinese = chinese;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }}
