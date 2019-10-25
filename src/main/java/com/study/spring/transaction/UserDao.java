package com.study.spring.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

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
        User user = new User(new Random().nextInt(), "vilderlee", 25);
        Score score = new Score(new Random().nextInt(), new Random().nextInt());
        jdbcTemplate.update("insert into user (id,username, age) values (?,?,?)", user.getId(),user
        .getUsername(),user.getAge());
        int a = 10/0;
//        jdbcTemplate.update("insert into score (id,userID) values (?,?)", score.getId(),score.getUserID());
    }
}
