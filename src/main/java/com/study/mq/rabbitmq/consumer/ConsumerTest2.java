package com.study.mq.rabbitmq.consumer;

import com.study.mq.rabbitmq.connect.RabbitMQConnectFactory;

import java.io.IOException;

/**
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/1/14      Create this file
 * </pre>
 */
public class ConsumerTest2 {
    public static void main(String[] args) {
        RabbitMQConnectFactory factory = new RabbitMQConnectFactory();
        factory.connect();

        try {

            while (true) {
                Thread.sleep(2000);
                factory.receive();

            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        factory.close();
    }
}
