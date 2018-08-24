package cn.vector.jms.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jms.*;
//import javax.jms.*;

@Component("producerService")
public class ProducerServiceImpl implements ProducerService {
    @Autowired
    JmsTemplate jmsTemplate;
    @Autowired
    @Resource(name = "topicDestination")
    Destination destination;

    @Override
    public void sendMessage(String message) {
        //使用JmsTemplate发送消息
        //创建消息
        jmsTemplate.send(destination, session -> {
            TextMessage textMessage = session.createTextMessage(message);
            return textMessage;
        });

        System.out.println("发送消息:" + message);
    }

}
