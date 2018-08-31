package com.vz.spring.cloud.mq.producter;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author zhangwei
 * @date 31/08/2018 17:36
 * @email victorzhang0929@hotmail.com
 */
@Component
public class Sender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String context = "vz " + new Date();
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("vz", context);
    }
}
