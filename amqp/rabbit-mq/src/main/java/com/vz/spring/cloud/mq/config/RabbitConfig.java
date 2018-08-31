package com.vz.spring.cloud.mq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author zhangwei
 * @date 31/08/2018 17:41
 * @email victorzhang0929@hotmail.com
 */
@Configuration
public class RabbitConfig {

    @Bean
    public Queue vzQueue() {
        return new Queue("vz");
    }

}
