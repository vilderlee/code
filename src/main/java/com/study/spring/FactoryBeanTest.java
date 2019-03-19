package com.study.spring;

import org.springframework.beans.factory.FactoryBean;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/2/28      Create this file
 * </pre>
 */
public class FactoryBeanTest implements FactoryBean {

//    public FactoryBeanTest() {
//        System.out.println("FactoryBean 已经初始化生成了 Constructors");
//    }

    @Override public Object getObject() throws Exception {
        System.out.println("FactoryBean 已经初始化生成了");
        return new Test();
    }

    @Override public Class<?> getObjectType() {
        return Test.class;
    }
}
