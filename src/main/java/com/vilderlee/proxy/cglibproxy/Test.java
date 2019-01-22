package com.vilderlee.proxy.cglibproxy;

import net.sf.cglib.core.DebuggingClassWriter;

/**
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/1/21      Create this file
 * </pre>
 */
public class Test {
    public static void main(String[] args) throws Throwable {

        Person person = (Person) ProxyFactory.getInstance(Person.class);
        person.eat("肉");
        person.sayHello();
    }
}
