package com.vilderlee.proxy.proxystatic;

/**
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/1/15      Create this file
 * </pre>
 */
public class StaticProxy implements Eat{
    private Dog dog;
    private String words;

    public StaticProxy(String words) {
        this.words = words;
    }

    @Override
    public void eat() {
        dog = new Dog(words);
        dog.eat();
    }
}
