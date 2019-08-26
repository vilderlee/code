package com.vilderlee.design.commandchain;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/7/26      Create this file
 * </pre>
 */

@ComponentScan("com.vilderlee.design.commandchain")
@ImportResource("classpath:spring-transaction.xml")
public class Main {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);

        Environment.ApplicationContext = context;
        Environment.init();
        Tx1100RiskCommandChain tx1100CommandChain = new Tx1100RiskCommandChain();
        Context context1 = new Context();

        context1.put("txCode", "1010");
        System.out.println(tx1100CommandChain.rollback(context1));

        Stream.of("one", "two", "three", "four")
                         .filter(e -> e.length() > 3)
                         .peek(e -> System.out.println("Filtered value: " + e))
                         .map(String::toUpperCase)
                         .peek(e -> System.out.println("Mapped value: " + e))
                         .collect(Collectors.toList());
    }

}
