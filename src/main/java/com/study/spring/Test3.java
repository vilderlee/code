package com.study.spring;

import org.springframework.context.LifecycleProcessor;
import org.springframework.context.SmartLifecycle;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/2/27      Create this file
 * </pre>
 */
public class Test3 implements SmartLifecycle {
    private Test2 test2;
    private boolean autoStart;

    public void test3(){
        System.out.println("test3");
        test2.test2();
    }

    public Test2 getTest2() {
        return test2;
    }

    public void setTest2(Test2 test2) {
        this.test2 = test2;
    }

    @Override
    public boolean isAutoStartup() {
        return isAutoStart();
    }

    @Override public void start() {
        System.out.println("声明周期由spring管理");
    }

    @Override public void stop() {
        System.out.println("声明周期由spring管理-----close");
    }

    @Override public boolean isRunning() {
        return false;
    }

    public boolean isAutoStart() {
        return autoStart;
    }

    public void setAutoStart(boolean autoStart) {
        this.autoStart = autoStart;
    }
}
