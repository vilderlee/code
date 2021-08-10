package com.vilderlee.proxy.javaagent;


import com.sun.tools.attach.AgentInitializationException;
import com.sun.tools.attach.AgentLoadException;
import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;

import java.io.IOException;

/**
 * Attacher
 *
 * @ClassName Attacher
 * @Description
 * @Author VilderLee
 * @Date 2021/7/31 6:21 下午
 */

public class Attacher {
    public static void main(String[] args) throws AgentLoadException, IOException, AgentInitializationException, AttachNotSupportedException {
        VirtualMachine virtualMachine = VirtualMachine.attach("53072");
        virtualMachine.loadAgent("/Users/vilder/IdeaProjects/code/testJavaAgent/target/testJavaAgent-1.0-SNAPSHOT.jar");
    }
}
