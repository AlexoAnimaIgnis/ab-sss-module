package com.anima.socialsecuritysystem.messaging;

import com.anima.socialsecuritysystem.entities.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

@Service
public class JmsUserMessagingService implements UserMessagingService {

    private JmsTemplate jmsTemplate;

    @Autowired
    public JmsUserMessagingService(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @Override
    public void sendUser(User user) {
        jmsTemplate.send(session -> session.createObjectMessage(user));
    }
}
