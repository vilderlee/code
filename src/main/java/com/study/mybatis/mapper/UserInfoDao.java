package com.study.mybatis.mapper;

import com.study.mybatis.User;

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
}
