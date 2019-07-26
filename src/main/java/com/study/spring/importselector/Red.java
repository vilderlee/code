package com.study.spring.importselector;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 功能描述:
 *
 * @package com.study.spring.importselector
 * @auther vilderlee
 * @date 2019-06-29 22:37
 */
@Component
public class Red implements InitializingBean {

    @PostConstruct()
    public void red(){
        System.out.println("this is color red!");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("this is afterPropertiesSet");
    }
}
