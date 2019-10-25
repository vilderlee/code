package com.study.spring.cycle;

import com.alibaba.fastjson.JSON;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/7/15      Create this file
 * </pre>
 */
@ComponentScan("com.study.spring.cycle")
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
//        TestA testA = (TestA) context.getBean("testA");
//        testA.test();
        
        String string = "{'bankAccountName':'刁先','bankAccountNumber':'620411399268124310','bankID':'102'," 
                + "'businessType':'BANK_ACCT_3','contextID':'201909161504278999033102394','credentialNumber':'542133199511054619',"
                + "'credentialType':'IDENTIFICATION','customerName':'刁先','customerType':[{'RETAIL':'1','OMG':'4546'},"
                + "{'RETAIL2':'2'}],"
                + "'institutionID':'700001',"
                + "'institutionParentID':'700001','rootID':'201909161504278999033102394','txSN':'201909161504278999033102394','txType':'4611'}";

        Map parse = JSON.parseObject(string, Map.class);
        System.out.println();
    }
}
