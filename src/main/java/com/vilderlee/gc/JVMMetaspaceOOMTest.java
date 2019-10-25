package com.vilderlee.gc;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/10/14      Create this file
 *
 *
 * -XX:+UseParNewGC
 *
 * -XX:+UseConcMarkSweepGC
 *
 * -XX:MetaspaceSize=10m
 *
 * -XX:MaxMetaspaceSize=10m
 *
 * -XX:+PrintGCDetails
 *
 * -Xloggc:gc.log
 *
 * -XX:+HeapDumpOnOutOfMemoryError
 *
 * -XX:HeapDumpPath=./
 *
 * </pre>
 */
public class JVMMetaspaceOOMTest {
    public static void main(String[] args) {

        long count = 0;

        while (true) {

            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(SafeCar.class);
            enhancer.setCallback(new MethodInterceptor() {
                @Override public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy)
                        throws Throwable {
                    if (method.getName().equals("run")) {
                        System.out.println("检查开始");
                        return proxy.invokeSuper(obj, args);
                    } else {
                        return proxy.invokeSuper(obj, args);
                    }
                }
            });
            Car car = (Car) enhancer.create();
            car.run();

            System.out.println("已经创建了" + ++count + "个Car对象!");
        }
    }

    static class Car {
        public void run() {
            System.out.println("Car is starting!");
        }
    }

    static class SafeCar extends Car {
        @Override public void run() {
            System.out.println("SafeCar is starting!");
            super.run();
        }
    }

}
