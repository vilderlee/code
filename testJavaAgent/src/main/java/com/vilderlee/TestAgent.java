package com.vilderlee;

import java.lang.instrument.Instrumentation;

/**
 * TestAgent
 *
 * @ClassName TestAgent
 * @Description
 * @Author VilderLee
 * @Date 2021/7/31 5:53 下午
 */

public class TestAgent {

    public static void agentmain(String args, Instrumentation instrumentation){
        instrumentation.addTransformer(new TestTransformer(), true);

        try {
            Class c = Class.forName("com.vilderlee.proxy.javaagent.Base");
            instrumentation.retransformClasses(c);
            System.out.println("Agent load done.");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
