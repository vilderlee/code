package com.vilderlee.proxy.proxydynamic;

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

    @Override public int update(String sql, Object parameter, Statement statement) throws SQLException {
        return 0;
    }

    @Override public List query() throws SQLException {
        return null;
    }
}
