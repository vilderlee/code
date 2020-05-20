package com.study.dispatcher;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/12/16      Create this file
 * </pre>
 */
@Component
public class Dispatcher implements ApplicationContextAware {

    private ApplicationContext context;

    public void dispatcher(int depositMode, String txType) {
        Map<String, Object> beansWithAnnotation = context.getBeansWithAnnotation(DepositMode.class);
        beansWithAnnotation.forEach((key, value) -> {
            DepositMode annotation = value.getClass().getAnnotation(DepositMode.class);
            TxTypeEnum txTypeEnum = annotation.txType();
            int[] ints = annotation.depositMode();
            List list = Arrays.asList(ints);
            if (txTypeEnum.getTxCode().equals(txType) && list.contains(depositMode)) {
                ((Executor) value).execute();
            }
        });
    }

    @Override public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }


}
