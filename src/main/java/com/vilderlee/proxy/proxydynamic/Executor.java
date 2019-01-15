package com.vilderlee.proxy.proxydynamic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/1/15      Create this file
 * </pre>
 */
public interface Executor {

    int update(String sql, Object parameter, Statement statement) throws SQLException;

    List query() throws SQLException;
}
