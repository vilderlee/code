package com.study.compant.bean;

import com.study.compant.JavaConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/4/19      Create this file
 * </pre>
 */

@Component
public class Test1 {
    @Autowired private List<AbstractTx1> list;

    public void doIt(){
        list.forEach(AbstractTx1::tx1002);
    }


    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);


        Test1 tx1002 =  context.getBean(Test1.class);
        tx1002.doIt();
    }
}
