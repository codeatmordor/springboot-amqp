
// PACKAGE/IMPORTS --------------------------------------------------
package com.gk.springamqp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {

    private static final Logger log = LoggerFactory.getLogger(MessageSender.class);

    public void sendMessage(RabbitTemplate rabbitTemplate, String exchange, String rKey, Object data) {
        log.info("Sending message to the queue using routingKey {}. Message= {}", rKey, data);
        rabbitTemplate.convertAndSend(rKey, data);
        log.info("The message has been sent to the queue.");

    }
}
