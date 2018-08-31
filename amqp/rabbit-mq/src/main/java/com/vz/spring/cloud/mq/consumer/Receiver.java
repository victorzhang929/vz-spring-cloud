package com.vz.spring.cloud.mq.consumer;

import org.springframework.stereotype.Component;

/**
 * @author zhangwei
 * @date 31/08/2018 17:38
 * @email victorzhang0929@hotmail.com
 */
@Component
//@RabbitListener(queues = "vz")
public class Receiver {

//    @RabbitHandler
    public void process(String vz) {
        System.out.println("Receiver: " + vz);
    }
}
