package com.study.mq.rabbitmq.fanout;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import com.rabbitmq.client.MessageProperties;
import com.vilderlee.serialize.SerializeUtil;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/4/1      Create this file
 * </pre>
 */
public class Consumer1 {

    private static String QUEUE_NAME = "demoQueue78789";
    private static String EXCHANGE_NAME = "demoExchange";
    private static String ROUTINGKEY = "demoRoutingKey";
    private static String RABBITMQ_VirtualHost = ConnectionFactory.DEFAULT_VHOST;
    private static String RABBITMQ_URL = "39.104.159.18";
    private static int RABBITMQ_PORT = 5672;
    private static String RABBITMQ_USERNAME = "lichao";
    private static String RABBITMQ_PASSWORD = "lichao.5220246";

    public static void main(String[] args) throws Exception{

        ConnectionFactory connectionFactory = new ConnectionFactory();
        //2.指定连接主机地址
        connectionFactory.setHost(RABBITMQ_URL);
        //3.指定端口
        connectionFactory.setPort(RABBITMQ_PORT);
        //4.用户名
        connectionFactory.setUsername(RABBITMQ_USERNAME);
        //5.密码
        connectionFactory.setPassword(RABBITMQ_PASSWORD);
        //6.指定虚拟主机（相当于命名空间，指定Exchange和Queue在哪个Virtual host中）
        connectionFactory.setVirtualHost(RABBITMQ_VirtualHost);
        //7.设置连接超时时间
        connectionFactory.setConnectionTimeout(30000);

        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();

        DeliverCallback deliverCallback = (consumer, deliver) -> {
            System.out.println("consumer:" + consumer);
            System.out.println("接收到的数据:" + new String(deliver.getBody()));
        };
        channel.queueDeclare("fanoutQueue1",true,false,false,null);
        channel.queueBind("fanoutQueue1","fanoutExchangeTest","fanoutExchangeTest");
        channel.basicConsume("fanoutQueue1", deliverCallback, (CancelCallback) null);
    }
}
