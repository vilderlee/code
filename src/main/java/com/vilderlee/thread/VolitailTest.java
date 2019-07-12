package com.vilderlee.thread;

import java.util.concurrent.TimeUnit;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/6/26      Create this file
 * </pre>
 */
public class VolitailTest {

    public static void main(String[] args) {
        Task task = new Task();

        new Thread(()-> task.add()).start();

        while (task.num == 0) {

        }

        System.out.println("Task num is update " + task.num);
    }

}



class Task{

    protected  int num = 0;

    public void add(){

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.num = 3;
    }

}