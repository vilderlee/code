package com.study.spring.aop.service.impl;

import com.study.spring.aop.service.BaseService;

/**
 * 功能描述:
 *
 * @package com.study.spring.aop.service.impl
 * @auther vilderlee
 * @date 2019-01-23 23:16
 */
public class Person implements BaseService {
    @Override
    public void eat() {
        System.out.println("我吃肉");
    }

    public void eat(String string){
        System.out.println("我吃gou");
    }

    @Override
    public void wc() {
        System.out.println("在马桶上拉屎");
    }
}
