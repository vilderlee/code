package com.study.spring.condition;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;

/**
 * Config
 *
 * @ClassName Config
 * @Description
 * @Author VilderLee
 * @Date 2021/2/2 4:25 下午
 */

@Conditional(ConditionTest.class)
@ComponentScan("com.study.spring.condition")
public class Config {
}
