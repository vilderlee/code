package com.study.mybatis.mapper;

import com.study.mybatis.User;

import java.util.List;

/**
 * 功能描述:
 *
 * @package com.study.mybatis.mapper
 * @auther vilderlee
 * @date 2019-01-13 10:45
 */
public interface UserInfoDao {
    User getUserInfo(String userId);

    void insertUserInfo(User user);

    void insertUserInfoBatch(List<User> list);
}
