package com.vz.spring.cloud.steam.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * @author zhangwei
 * @date 04/09/2018 10:18
 * @email victorzhang0929@hotmail.com
 */
@EnableBinding(value = {SinkSender.class})
public class SinkReceiver {

    private static final Logger logger = LoggerFactory.getLogger(SinkReceiver.class);

    @StreamListener(Sink.INPUT)
    public void receiver(String payload) {
        logger.info("Received: {}", payload);
    }
}
