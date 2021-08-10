package com.study.spring.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.stereotype.Component;

/**
 * ConditionTest
 *
 * @ClassName ConditionTest
 * @Description
 * @Author VilderLee
 * @Date 2021/2/2 4:26 下午
 */
public class ConditionTest implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return false;
    }
}
