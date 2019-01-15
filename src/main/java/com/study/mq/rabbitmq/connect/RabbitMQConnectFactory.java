package com.study.mq.rabbitmq.connect;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import com.rabbitmq.client.MessageProperties;
import com.vilderlee.serialize.SerializeUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/1/14      Create this file
 * </pre>
 */
public class RabbitMQConnectFactory {
    private String QUEUE_NAME = "demoQueue";
    private String EXCHANGE_NAME = "demoExchange";
    private String ROUTINGKEY = "demoRoutingKey";
    private String RABBITMQ_VirtualHost = ConnectionFactory.DEFAULT_VHOST;
    private String RABBITMQ_URL = "39.104.159.18";
    private int RABBITMQ_PORT = 5672;
    private String RABBITMQ_USERNAME = "lichao";
    private String RABBITMQ_PASSWORD = "lichao.5220246";

    private ConnectionFactory connectionFactory;
    private Channel channel;
    Connection connection;

    public void connect() {
        //1.实例化一个连接工厂(ConnectFactory)
        connectionFactory = new ConnectionFactory();
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

        try {
            //8.通过connectionFactory新建一个连接
            connection = connectionFactory.newConnection();
            //9.为当前连接指定一个通道
            channel = connection.createChannel();
            /**
             *
             *  String exchange,    Exchange名称
             *  BuiltinExchangeType type,   exchange类型[DIRECT("direct"), FANOUT("fanout"), TOPIC("topic"), HEADERS("headers")]
             *  boolean durable,    是否持久化（高可用的保证,保证交换机持久化）
             *  boolean autoDelete, 是否自动删除,当它不被使用的Exchange服务器会自动删除
             *  boolean internal,   是否内部存在，如果为true那么这个Exchange不能直接给客户端使用
             *  Map<String, Object> arguments   额外参数,在spring与rabbitMQ整合的代码中,该参数为空
             */
            //10.声明一个Exchange，如果MQ服务器中没有则新建。
            channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT, true, false, false, null);
            /**
             *
             *  String queue,    Queue名称
             *  boolean durable, 是否持久化（高可用的保证,保证队列持久化）
             *  boolean exclusive,   是否时独占的,true为独占即为该连接中才可使用
             *  boolean autoDelete,  是否自动删除,当它不被使用的Queue服务器会自动删除
             *  Map<String, Object> arguments    额外参数,在spring与rabbitMQ整合的代码中,该参数为空
             */
            //11.声明一个Queue，如果MQ服务器中没有则新建。
            channel.queueDeclare(QUEUE_NAME, true, false, false, null);
            /**
             *  String queue,   Queue名称
             *  String exchange,    Exchange名称
             *  String routingKey,  Queue与Exchange绑定Key
             *  Map<String, Object> arguments   额外参数,在spring与rabbitMQ整合的代码中,该参数为空
             *
             */
            //12.建立绑定关系
            channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, ROUTINGKEY, null);
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void send(Object object) throws Exception {
        byte[] bytes = SerializeUtil.serialize(object);

        /***
         *
         *  Return机制:
         *      确保消息发送到Queue中,当发送失败,当前方法回调
         *  Confirm机制:
         *      需要在channel中开启 channel.confirmSelect()
         *      确保消息发送到Exchange中,当数据发送到Exchange,第一个参数会回调,发送失败第二个参数回调
         *
         */
        //13.开启Confirm机制
        channel.confirmSelect();
        try {
            channel.addReturnListener(returnMessage -> {
                System.out.println("Exchange:" + returnMessage.getExchange());
                System.out.println("RoutingKey:" + returnMessage.getRoutingKey());
                System.out.println("ReplyCode:" + returnMessage.getReplyCode());
                System.out.println("ReplyText:" + returnMessage.getReplyText());
                System.out.println("Body:" + SerializeUtil.unSerialize(returnMessage.getBody()).toString());
            });
            channel.addConfirmListener((deliveryTag, multiple) -> {
                System.out.println("deliveryTag1:" + deliveryTag);
                System.out.println("multiple1:" + multiple);
            }, (deliveryTag, multiple) -> {
                System.out.println("deliveryTag2:" + deliveryTag);
                System.out.println("multiple2:" + multiple);
            });
            channel.basicPublish(EXCHANGE_NAME, ROUTINGKEY, true, MessageProperties.PERSISTENT_TEXT_PLAIN, bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void receive() throws IOException {

        /**
         *
         * 消费者接收消息后需通过该方法回调进行消息处理
         *
         */
        DeliverCallback deliverCallback = (consumer, deliver) -> {
            System.out.println("consumer:" + consumer);
            Object object = SerializeUtil.unSerialize(deliver.getBody());
            System.out.println("接收到的数据:" + object.toString());

            /**
             *
             * long deliveryTag,  消息投递唯一标识
             * boolean multiple
             *                 true:确认所有的消息包括已经接受的投递标识,
             *                 false:确认已经接受的投递标识
             */
            //消息确认被确认
            channel.basicAck(deliver.getEnvelope().getDeliveryTag(), true);

            /**
             * long deliveryTag,    消息投递唯一标识
             * boolean multiple,
             *                  true:拒绝所有的消息包括已经接受的投递标识,
             *              *   false:拒绝已经接受的投递标识
             * boolean requeue  是否重新放入队列
             *
             */
            //消息没有被确认
            channel.basicNack(deliver.getEnvelope().getDeliveryTag(), true, true);
        };

        /**
         * 设置通道的请求数,其实这里指的是在消费端消息最大的存储数（也就是没有被消费者确认消费的消息）
         */
        channel.basicQos(3);
        /**
         * String queue,    队列名称
         * boolean autoAck, 是否主动确认(不太建议，可能会造成消息丢失情况，当)
         * DeliverCallback deliverCallback, 消息被投递时的回调函数
         * CancelCallback cancelCallback    消费者被取消是的回调函数
         */
        //接受消息
        channel.basicConsume(QUEUE_NAME, false, deliverCallback, (CancelCallback) null);
    }

    public void close() {
        try {
            channel.close();
            connection.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }



}
