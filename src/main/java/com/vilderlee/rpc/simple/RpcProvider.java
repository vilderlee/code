package com.vilderlee.rpc.simple;

import com.vilderlee.rpc.HelloService;
import com.vilderlee.rpc.HelloServiceImpl;

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
public class RpcProvider {
    public static void main(String[] args) throws Exception {
        RpcFramework.export(new HelloServiceImpl(), HelloService.class);
    }
}
