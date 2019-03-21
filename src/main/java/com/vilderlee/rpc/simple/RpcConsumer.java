package com.vilderlee.rpc.simple;

import com.vilderlee.rpc.HelloService;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/3/21      Create this file
 * </pre>
 */
public class RpcConsumer {

    public static void main(String[] args) throws Exception {
        HelloService s = (HelloService) RpcFramework.refer(HelloService.class, "127.0.0.1", 9999);
        System.out.println(s.sayHello(" world!"));
    }
}
