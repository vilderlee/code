package com.study.mybatis;


import com.study.mybatis.mapper.UserInfoDao;
import com.study.mybatis.utils.FlagEnum;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 功能描述:
 *
 * @package com.study.mybatis
 * @auther vilderlee
 * @date 2019-01-12 17:13
 */
public class MybatisTest {

    public static void main(String[] args) {
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = sqlSessionFactory.openSession();

            UserInfoDao userInfoDao = (UserInfoDao) session.getMapper(UserInfoDao.class);
            User user = (User) userInfoDao.getUserInfo("0001");

//            User user = session.selectOne("com.study.mybatis.mapper.UserInfoDao.getUserInfo", "0001");
            System.out.println(user.toString());

            User insertUser = new User();
            insertUser.setUserId("0004");
            insertUser.setUserName("wangzhao");
            insertUser.setFlag(FlagEnum.FLAG_FALSE);

            session.insert("com.study.mybatis.mapper.UserInfoDao.insertUserInfo", insertUser);

            User user2 = session.selectOne("com.study.mybatis.mapper.UserInfoDao.getUserInfo", "0002");
            System.out.println(user2.toString());
            session.commit();
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
