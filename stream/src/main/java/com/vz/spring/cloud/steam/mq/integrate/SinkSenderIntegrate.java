package com.vz.spring.cloud.steam.mq.integrate;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;

import java.util.Date;

/**
 * @author zhangwei
 * @date 04/09/2018 16:13
 * @email victorzhang0929@hotmail.com
 */
@EnableBinding(value = SinkSenderIntegrate.SinkOutput.class)
public class SinkSenderIntegrate {

    @Bean
    @InboundChannelAdapter(value =SinkOutput.OUTPUT, poller = @Poller(fixedDelay = "2000"))
    public MessageSource<Date> timeMessageSource() {
        return () -> new GenericMessage<>(new Date());
    }

    public interface SinkOutput {
        String OUTPUT = "vz";

        @Output(SinkOutput.OUTPUT)
        MessageChannel output();
    }
}
