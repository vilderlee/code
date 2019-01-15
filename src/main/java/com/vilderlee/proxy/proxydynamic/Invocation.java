package com.vilderlee.proxy.proxydynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * JDK动态代理
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/1/15      Create this file
 * </pre>
 */
public class Invocation implements InvocationHandler {
    private static final String URL = "jdbc:mysql://39.104.159.18:3306/springboot";
    private static final String USER_NAME = "springboot";
    private static final String PASSWORD = "springboot";

    private Executor realObject;

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public Invocation(Executor realObject) {
        this.realObject = realObject;
    }

    @Override public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        init();
        Object o = method.invoke(realObject, args);
        close();
        return o;
    }

    private void init() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            preparedStatement =connection.prepareStatement("select * from user_info");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void close() {
        try {
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
