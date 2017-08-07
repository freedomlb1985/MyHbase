package com.frey.activemq;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTextMessage;

import javax.jms.*;
import java.util.Arrays;

/**
 * Created by frey on 2017/8/2.
 */
public class JMSPublisher {
    //默认连接用户名
    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
    //默认连接密码
    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
    //默认连接地址
//    private static final String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL;

//    private static final String BROKEURL = "failover:(tcp://localhost:61616,tcp://localhost:61626)";
private static final String BROKEURL = "failover:(tcp://node1:61616,tcp://node2:61616,tcp://node3:61616)";
    //发送的消息数量
    private static final int SENDNUM = 10000000;

    public static void main(String [] args) throws JMSException, InterruptedException {
        System.out.println(ActiveMQConnection.DEFAULT_BROKER_URL);
        ActiveMQConnectionFactory connectionFactory;
        TopicConnection topicConnection;
        TopicSession topicSession;
        Topic topic;
        TopicPublisher topicPublisher;
        connectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKEURL);
        topicConnection = connectionFactory.createTopicConnection();
        topicSession = topicConnection.createTopicSession(false, TopicSession.AUTO_ACKNOWLEDGE);
        topic = topicSession.createTopic("com.frey.topic1");
        topicPublisher = topicSession.createPublisher(topic);
        int i = 0;
        Message msg;
        byte [] bs = new byte[1024 * 1024];
        while(i < SENDNUM) {
            msg = topicSession.createTextMessage("Message - " + i);
            topicPublisher.publish(msg);
            System.out.println("published message: " + "Message - " + i);
            Thread.sleep(500);
            i++;
        }
    }
}
