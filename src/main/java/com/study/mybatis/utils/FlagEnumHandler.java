package com.study.mybatis.utils;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 功能描述:
 *
 * @package com.study.mybatis.utils
 * @auther vilderlee
 * @date 2019-01-13 19:25
 */
public class FlagEnumHandler implements TypeHandler {


    /**
     * 根据方法名称可知，这个方法是在insert、update中使用的，用来将实体类的参数转化为数据库类型的参数
     *
     * @param ps        jdbc中要执行的statement
     * @param i         statement的第i个参数
     * @param parameter 参数对象
     * @param jdbcType  jdbc允许的对象类型
     * @throws SQLException
     */
    @Override
    public void setParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException {
        if (parameter == null) {
            ps.setInt(i, 0);
            return;
        }

        FlagEnum flag = (FlagEnum) parameter;
        if (flag.isFlag()) {
            ps.setInt(i, 1);
        } else {
            ps.setInt(i, 0);
        }
    }


    /**
     * 用于将查询结果进行转换
     *
     * @param rs         jdbc执行后的结果集
     * @param columnName 列名称
     * @return
     * @throws SQLException
     */
    @Override
    public Object getResult(ResultSet rs, String columnName) throws SQLException {
        int flag = rs.getInt(columnName);
        Boolean flagBoolean = Boolean.FALSE;
        if (flag == 1) {
            flagBoolean = Boolean.TRUE;
        }

        return FlagEnum.getValue(flagBoolean);
    }

    @Override
    public Object getResult(ResultSet rs, int columnIndex) throws SQLException {
        return null;
    }

    @Override
    public Object getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return null;
    }
}
