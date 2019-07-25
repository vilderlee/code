package com.study.spring.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/7/18      Create this file
 * </pre>
 */
@Component("userDao")
public class UserDao {

    @Autowired private JdbcTemplate jdbcTemplate;

    @Transactional
    public void insert() {
        User user = new User(1, "vilderlee", 25);
        Score score = new Score(1, 1);
        jdbcTemplate.update("insert into user (id,username, age) values (?,?,?)", user);
        jdbcTemplate.update("insert into score (id,userID) values (,?,?)", score);
    }
}
