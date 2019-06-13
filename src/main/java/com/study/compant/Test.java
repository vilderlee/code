package com.study.compant;

import com.study.compant.bean.AbstractTx;
import com.study.compant.bean.Tx1002;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/4/12      Create this file
 * </pre>
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);


        AbstractTx tx1002 =  context.getBean(Tx1002.class);
        tx1002.say();

    }
}
