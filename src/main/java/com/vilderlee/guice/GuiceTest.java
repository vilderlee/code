package com.vilderlee.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

import javax.inject.Singleton;
import java.util.HashMap;
import java.util.Map;

/**
 * GuiceTest
 *
 * @ClassName GuiceTest
 * @Description
 * @Author VilderLee
 * @Date 2021/3/17 5:26 下午
 */

public class GuiceTest {
    @Inject
    private Animal animal;

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new MainModule());
        GuiceTest guiceTest = new GuiceTest();
        injector.injectMembers(guiceTest);

        System.out.println(guiceTest.animal);
        System.out.println(injector.getInstance(Animal.class));
        System.out.println(injector.getInstance(Animal.class));

        guiceTest.animal.run();
    }
}


interface Animal {
    void run();
}

@Singleton
class Dog implements Animal {

    @Override
    public void run() {
        System.out.println("Dog");
    }
}

class Cat implements Animal {

    @Override
    public void run() {
        System.out.println("Cat");
    }
}

class MainModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Animal.class).to(Dog.class);
    }
}

