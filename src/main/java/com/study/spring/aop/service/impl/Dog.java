package com.study.spring.aop.service.impl;

import com.study.spring.aop.service.BaseService;

/**
 * 功能描述:
 *
 * @package com.study.spring.aop.service.impl
 * @auther vilderlee
 * @date 2019-01-23 23:16
 */
public class Dog implements BaseService {
    @Override
    public void eat() {
        System.out.println("啃骨头");
    }

    @Override
    public void wc() {
        System.out.println("找棵树");
    }
}
