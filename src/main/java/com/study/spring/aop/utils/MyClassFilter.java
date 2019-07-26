package com.study.spring.aop.utils;

import com.study.spring.aop.service.impl.Person;
import org.springframework.aop.ClassFilter;

/**
 * 功能描述:
 *
 * @package com.study.spring.aop.utils
 * @auther vilderlee
 * @date 2019-01-23 23:23
 */
public class MyClassFilter implements ClassFilter {
    @Override
    public boolean matches(Class<?> clazz) {
        if (clazz == Person.class) {
            return true;
        }

        return false;
    }
}
