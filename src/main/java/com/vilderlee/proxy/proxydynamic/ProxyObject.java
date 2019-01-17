package com.vilderlee.proxy.proxydynamic;

import java.lang.reflect.Proxy;
import java.sql.PreparedStatement;

/**
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/1/15      Create this file
 * </pre>
 */
public class ProxyObject {


    public static Executor getInstance(Class c) throws Exception {
        Executor obj = (Executor) c.newInstance();
        Invocation invocation = new Invocation(obj);
        return (Executor) Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), invocation);
    }

    public static void main(String[] args) throws Exception {
        Executor sqlSession = ProxyObject.getInstance(SQLSession.class);
        sqlSession.query("", null);
    }
}
