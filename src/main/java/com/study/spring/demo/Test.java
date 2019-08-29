package com.study.spring.demo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 功能描述:
 *
 * @package com.study.spring
 * @auther vilderlee
 * @date 2019-01-17 20:50
 */
public class Test extends StaticTest implements BeanNameAware, BeanFactoryAware, InitializingBean, ApplicationContextAware {

    public Test() {
        System.out.println("这是我的构造方法");
    }

    static {
        System.out.println("我是一个静态代码块");
    }


    public static void staticMethod(){
        System.out.println("这是一个静态方法");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("我要设置我的名字了：" + name);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("设置beanFactory工厂了");
    }



    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("经常被用");
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("我在哪儿");
    }

    public void destroy(){
        System.out.println("Destroy~~~~~");
    }
}
