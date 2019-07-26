package com.vilderlee.design.commandchain;

import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/7/26      Create this file
 * </pre>
 */
public class Environment {
    public static ApplicationContext ApplicationContext;

    public static Map map;


    public static void init(){
        JdbcTemplate jdbcTemplate = Environment.ApplicationContext.getBean(JdbcTemplate.class);
        String sql = "SELECT * FROM RiskTransInfo";

        List<RiskTransInfo> list = jdbcTemplate
                .query(sql, BeanPropertyRowMapper.newInstance(RiskTransInfo.class));


        map =  list.stream().collect(Collectors.groupingBy(RiskTransInfo::getRiskCommand));
        System.out.println(map);
    }
}
