package cn.itcast.rabbitmq.routing;

import cn.itcast.rabbitmq.util.ConnectionUtil;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class Send {

    private final static String EXCHANGE_NAME = "amqpExchange";

    public static void main(String[] argv) throws Exception {
        // 获取到连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        // 声明exchange
//        channel.exchangeDeclare(EXCHANGE_NAME, "direct");

        // 消息内容
        String message = "3";
        channel.basicPublish(EXCHANGE_NAME, "push:add_business_comment", null, message.getBytes());
        System.out.println(" 后台系统： '" + message + "'");

        channel.close();
        connection.close();
    }
}