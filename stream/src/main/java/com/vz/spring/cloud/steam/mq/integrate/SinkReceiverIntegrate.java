package com.vz.spring.cloud.steam.mq.integrate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhangwei
 * @date 04/09/2018 16:11
 * @email victorzhang0929@hotmail.com
 */
@EnableBinding(value = SinkSenderIntegrate.SinkOutput.class)
public class SinkReceiverIntegrate {

    private static final Logger logger = LoggerFactory.getLogger(SinkReceiverIntegrate.class);

    @ServiceActivator(inputChannel = SinkSenderIntegrate.SinkOutput.OUTPUT)
    public void receive(String message) {
        logger.info("Received: {}", message);
    }

    @Transformer(inputChannel = SinkSenderIntegrate.SinkOutput.OUTPUT, outputChannel = SinkSenderIntegrate.SinkOutput.OUTPUT)
    public String transform(Date message) {
        return new SimpleDateFormat("yyyy-MM-dd").format(message);
    }

}
