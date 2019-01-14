package com.vilderlee.mq.rabbitmq.provider;

import com.vilderlee.mq.rabbitmq.connect.RabbitMQConnectFactory;

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
        rabbitMQConnectFactory.send("lichao");
        rabbitMQConnectFactory.close();
    }
}
