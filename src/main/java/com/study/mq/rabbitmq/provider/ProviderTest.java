package com.study.mq.rabbitmq.provider;

import com.study.mq.rabbitmq.connect.RabbitMQConnectFactory;

import java.util.concurrent.TimeUnit;

/**
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/1/14      Create this file
 * </pre>
 */
public class ProviderTest {

    public static void main(String[] args) throws Exception {
        RabbitMQConnectFactory rabbitMQConnectFactory = new RabbitMQConnectFactory();
        rabbitMQConnectFactory.connect();
        int i = 0;
        while (i < 10) {
            User user = new User();
            user.setAge(25);
            user.setUserName("lichao");
            rabbitMQConnectFactory.send(user);
            i++;
        }
        TimeUnit.SECONDS.sleep(2);
        rabbitMQConnectFactory.close();
    }
}
