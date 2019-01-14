package com.vilderlee.jdbc;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 功能描述:
 *
 * @package com.vilderlee.jdbc
 * @auther vilderlee
 * @date 2019-01-12 20:10
 */
public class JdbcTest {
    public static void main(String[] args) throws Exception {
        Class c = Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://39.104.159.18:3306/springboot","springboot","springboot");
        PreparedStatement statement = (PreparedStatement) connection.createStatement();
        ResultSet resultSet = statement.executeQuery();
//        statement.setString();

    }
}
