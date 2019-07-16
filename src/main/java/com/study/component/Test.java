package com.study.component;

import com.study.component.bean.AbstractTx;
import com.study.component.bean.Tx1002;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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
