package com.study.component.bean;

import com.study.component.JavaConfig;
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
public class Test {
    @Autowired private List<AbstractTx> list;

    public void doIt(){
        list.forEach(AbstractTx::tx1002);
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);


        Test tx1002 =  context.getBean(Test.class);
        tx1002.doIt();
    }
}
