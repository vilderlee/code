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


    public Object getInstance(SQLSession sqlSession) throws Exception {
        return Proxy.newProxyInstance(Executor.class.getClassLoader(), new Class[]{Executor.class}, new Invocation(sqlSession));
    }

    public static void main(String[] args) throws Exception {
        ProxyObject proxyObject = new ProxyObject();
        Executor executor = (Executor) proxyObject.getInstance(new SQLSession());
        executor.query();
    }
}
