package com.study.spring.aop.annotation.aspectj;

import com.study.spring.aop.service.BaseService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 功能描述:
 *
 * @package com.study.spring.aop
 * @auther vilderlee
 * @date 2019-01-23 23:15
 */
public class AopTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
//        BaseService baseService = (BaseService) context.getBean("adviceProxy");
        BaseService baseService = (BaseService) context.getBean("advisorProxy");
        baseService.eat();
    }
}
