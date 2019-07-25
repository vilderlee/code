package com.vilderlee.thread.atomic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/7/4      Create this file
 * </pre>
 */
public class AtomicReferenceTest {

    @Data
    @ToString
    @AllArgsConstructor static class User {
        private String name;
        private int age;

    }


    public AtomicReference<User> atomicReference = new AtomicReference<>();

//    public void updateAtomic(User user) {
//        atomicReference.compareAndSet(this, user);
//    }

    public void update(User user) {
        user.setAge(user.getAge() + 1);
    }

    public static void main(String[] args) throws InterruptedException {
        AtomicReferenceTest test = new AtomicReferenceTest();
        User user = new User("vilderLee", 12);

        for (int i = 0; i < 10; i++) {
            new Thread(() -> test.update(user)).start();
        }

        TimeUnit.SECONDS.sleep(10);
        System.out.println(user);
    }
}
