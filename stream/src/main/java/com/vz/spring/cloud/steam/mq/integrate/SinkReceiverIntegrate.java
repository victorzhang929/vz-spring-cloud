package com.vz.spring.cloud.steam.mq.integrate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.annotation.ServiceActivator;

/**
 * @author zhangwei
 * @date 04/09/2018 16:11
 * @email victorzhang0929@hotmail.com
 */
@EnableBinding(value = SinkSenderIntegrate.class)
public class SinkReceiverIntegrate {

    private static final Logger logger = LoggerFactory.getLogger(SinkReceiverIntegrate.class);

    @ServiceActivator(inputChannel = SinkSenderIntegrate.SinkOutput.OUTPUT)
    public void receive(String payload) {
        logger.info("Received: {}", payload);
    }
}
