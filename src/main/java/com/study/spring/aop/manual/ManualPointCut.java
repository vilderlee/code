package com.study.spring.aop.manual;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;

import java.lang.reflect.Method;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/8/29      Create this file
 * </pre>
 */
public class ManualPointCut implements Pointcut {

    @Override public ClassFilter getClassFilter() {
        return new MyClassFilter();
    }

    @Override public MethodMatcher getMethodMatcher() {
        return new MyMethodMatcher();
    }

    static class MyClassFilter implements ClassFilter {
        @Override public boolean matches(Class<?> clazz) {
//            if (clazz.getName().equals(Target.class.getName())) {
//                return true;
//            } else {
//                return false;
//            }
            return true;
        }
    }

    static class MyMethodMatcher implements MethodMatcher {

        @Override public boolean matches(Method method, Class<?> targetClass) {
//            if (method.getName().equals("test")) {
//                return true;
//
//            }
//            return false;
            return true;
        }

        /**
         * 是否是动态拦截，如果是动态拦截使用下面有三个参数的方法，否则使用上面
         *
         * @return
         */
        @Override public boolean isRuntime() {
            return true;
        }

        @Override public boolean matches(Method method, Class<?> targetClass, Object... args) {
            if (method.getName().equals("test3")) {
                return true;
            } else {
                return false;
            }

        }
    }
}
