package com.study.spring.hierarchical;

import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Main
 *
 * @ClassName Main
 * @Description
 * @Author VilderLee
 * @Date 2021/4/30 10:27 下午
 */

public class Parent {

    public void test(){
        System.out.println("this is parent!");
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext parent = new AnnotationConfigApplicationContext();
        AnnotationConfigApplicationContext child = new AnnotationConfigApplicationContext();
        child.setParent(parent);
        parent.registerBeanDefinition("Parent", new RootBeanDefinition(Parent.class));
        parent.refresh();
        child.registerBeanDefinition("Child", new RootBeanDefinition(Child.class));
        child.refresh();
        parent.getBean(Parent.class).test();
        System.out.println("parent context contains 'Parent' Bean is " + parent.containsLocalBean("Parent"));
        System.out.println("child context contains 'Child' Bean is " + child.containsLocalBean("Child"));
        System.out.println("child context contains 'Parent' Bean is " + child.containsLocalBean("Parent"));
        System.out.println("parent context contains 'Child' Bean is " + parent.containsLocalBean("Child"));


    }
}
