package com.frey.activemq;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by frey on 2017/8/2.
 */
public class JMSSubscriber {
    //默认连接用户名
    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
    //默认连接密码
    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
    //默认连接地址
//    private static final String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL;
//    private static final String BROKEURL = "tcp://0.0.0.0:61616";
    private static final String BROKEURL = "failover:(tcp://node1:61616,tcp://node2:61616,tcp://node3:61616)";

    public static void main(String[] args) throws JMSException, InterruptedException {
        ActiveMQConnectionFactory connectionFactory;
        TopicConnection topicConnection;
        TopicSession topicSession;
        Topic topic;
        TopicSubscriber topicSubscriber;
        connectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKEURL);
        topicConnection = connectionFactory.createTopicConnection();
        topicConnection.start();
        topicSession = topicConnection.createTopicSession(false, TopicSession.AUTO_ACKNOWLEDGE);
        topic = topicSession.createTopic("com.frey.topic1");
        topicSubscriber = topicSession.createSubscriber(topic);
        topicSubscriber.setMessageListener(new TextMessageListener());
    }

}
