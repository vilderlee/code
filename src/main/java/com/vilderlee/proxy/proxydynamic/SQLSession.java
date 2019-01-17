package com.vilderlee.proxy.proxydynamic;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/1/15      Create this file
 * </pre>
 */
public class SQLSession implements Executor {

    private PreparedStatement statement;

    @Override
    public int update(String sql, Object parameter) throws SQLException {
        return 0;
    }

    @Override
    public List query(String sql, Object parameter) throws SQLException {
        List list = new ArrayList();
        ResultSet resultSet = statement.executeQuery(sql);
        int i = 0;
        while (resultSet.next()) {
            list.add(resultSet.getObject(i++));
        }
        resultSet.close();
        return list;
    }
}
