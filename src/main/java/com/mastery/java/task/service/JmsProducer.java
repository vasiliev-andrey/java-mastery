package com.mastery.java.task.service;

import com.mastery.java.task.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class JmsProducer {
    @Autowired
    JmsTemplate jmsTemplate;

    @Value("queue")
    String queue;

    public void send(Employee employee) {
        jmsTemplate.convertAndSend(queue, employee);
    }
}
