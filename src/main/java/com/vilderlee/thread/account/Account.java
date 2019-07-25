package com.vilderlee.thread.account;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
public class Account {

    private int id;
    private long balance;

    public Account(int id, long balance) {
        this.id = id;
        this.balance = balance;
    }

    public void deadLock(Account target, long amt) {

        synchronized (this) {
            synchronized (target) {
                if (this.balance > amt) {
                    this.balance -= amt;
                    target.balance += amt;
                }
            }
        }
    }

    public void charge(long amt) {

        synchronized (this) {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.balance += amt;
        }
    }

    /**
     * 死锁产生的条件有四个：
     *  1.互斥，共享资源X只能被A或B拿到
     *  2.占有且等待：A占有了资源X，在等待资源Y时，并不释放资源A   解决方法：一次拿到所有共享资源
     *  3.不可抢占：A占有资源不能被其他线程强行抢占
     *  4.循环等待：A占有资源X,等待Y资源，B占有资源Y,等待X资源。   解决方法：按顺序从小到大排列资源，依次获取资源
     *
     * @param target
     * @param amt
     */

    public void transfer(Account target, long amt) {
        while (!Allocator.INSTANCE.apply(this, target)) {
        }

        synchronized (this) {
            synchronized (target) {
                if (this.balance > amt) {
                    this.balance -= amt;
                    target.balance += amt;
                }
            }
        }
        Allocator.INSTANCE.free(this, target);
    }

    public void transfer2(Account target, long amt) {

        if (this.id > target.id) {
            synchronized (target) {
                synchronized (this) {
                    if (this.balance > amt) {
                        this.balance -= amt;
                        target.balance += amt;
                    }
                }
            }
        } else {
            synchronized (this) {
                synchronized (target) {
                    if (this.balance > amt) {
                        this.balance -= amt;
                        target.balance += amt;
                    }
                }
            }
        }

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    @Override public String toString() {
        return "Account{" + "id=" + id + ", balance=" + balance + '}';
    }
}

class Allocator {

    private Allocator() {
    }

    public static final Allocator INSTANCE = new Allocator();

    private List<Object> list = new ArrayList<>();

    synchronized boolean apply(Object from, Object to) {
        if (list.contains(from) || list.contains(to)) {
            return false;
        } else {
            list.add(from);
            list.add(to);
        }
        return true;
    }

    synchronized void free(Object from, Object to) {
        list.remove(from);
        list.remove(to);
    }
}

class Main {
    public static void main(String[] args) throws InterruptedException {
        Account a = new Account(1, 100);
        Account b = new Account(2, 100);

        new Thread(() -> a.deadLock(b, 10)).start();
        new Thread(() -> b.charge(50)).start();
        new Thread(() -> b.deadLock(a, 20)).start();

        Thread.sleep(5000);
        System.out.println(a);
        System.out.println(b);
    }
}