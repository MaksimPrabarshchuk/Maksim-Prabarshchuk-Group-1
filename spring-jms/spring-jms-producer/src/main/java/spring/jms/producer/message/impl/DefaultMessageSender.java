package spring.jms.producer.message.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import spring.jms.producer.message.MessageSender;

@Service("messageSender")
public class DefaultMessageSender implements MessageSender {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Override
    public void send(Map map) {
        jmsTemplate.convertAndSend(map);
    }
}
