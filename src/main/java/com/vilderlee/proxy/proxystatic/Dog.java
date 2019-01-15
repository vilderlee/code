package com.vilderlee.proxy.proxystatic;

/**
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/1/15      Create this file
 * </pre>
 */
public class Dog implements Eat{

    private String words;
    public Dog(String words) {
        this.words = words;
        say();
    }

    @Override
    public void eat() {
        System.out.println("吃骨头!");
    }

    private void say(){
        System.out.println(words);
    }
}
