package com.study.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 功能描述:
 *
 * @package com.study.spring
 * @auther vilderlee
 * @date 2019-01-17 21:00
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    public MyBeanPostProcessor() {
        System.out.println("MyBeanPostProcessor 已经初始化了");
    }

    @Override
    public Object postProcessBeforeInitialization(final Object bean, String beanName) throws BeansException {
        System.out.println("哼！postProcessBeforeInitialization！！");
        return bean;
    }


    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("哼！postProcessAfterInitialization！！");

        if (bean instanceof TestInterface) {
            Object proxy  = Proxy.newProxyInstance(bean.getClass().getClassLoader(), bean.getClass().getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    System.out.println("我开始搞事了！！！");
                    String returnObject = (String) method.invoke(bean, args);

                    return returnObject.toUpperCase();
                }
            });
            return proxy;
        }
        return bean;
    }
}
