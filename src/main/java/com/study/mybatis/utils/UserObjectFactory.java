package com.study.mybatis.utils;

import com.study.mybatis.User;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

import java.util.List;
import java.util.Properties;

/**
 * 功能描述:
 *
 * @package com.study.mybatis.utils
 * @auther vilderlee
 * @date 2019-01-13 20:41
 */
public class UserObjectFactory extends DefaultObjectFactory {

    /**
     * 这里只拿最简单的方法举例
     *
     * @param type 需要进行修改的实体对象
     * @return
     */
    @Override
    public Object create(Class type) {
        if (type == User.class) {
            User user = (User) super.create(type);
            user.setCountry("China");
            return user;
        }else {
            return super.create(type);
        }
    }

    @Override
    public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
        return super.create(type, constructorArgTypes, constructorArgs);
    }

    @Override
    public void setProperties(Properties properties) {
        super.setProperties(properties);
    }

    @Override
    protected Class<?> resolveInterface(Class<?> type) {
        return super.resolveInterface(type);
    }

    @Override
    public <T> boolean isCollection(Class<T> type) {
        return super.isCollection(type);
    }
}
