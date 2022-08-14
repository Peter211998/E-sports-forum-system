package com.sports.utils;

import com.sports.model.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;

/**
 * 生产者
 */
@Service
public class Publisher {
    @Autowired
    private JmsMessagingTemplate jmsMsgTemplate;

    /**
     * 发送topic
     *
     * @param destination
     * @param message
     */
    public void publish(Destination destination, String message) {
        jmsMsgTemplate.convertAndSend(destination, message);
    }
}
