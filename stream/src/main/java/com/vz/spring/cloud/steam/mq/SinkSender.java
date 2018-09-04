package com.vz.spring.cloud.steam.mq;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.MessageChannel;

/**
 * @author zhangwei
 * @date 04/09/2018 15:40
 * @email victorzhang0929@hotmail.com
 */
@EnableBinding(value = Sink.class)
public interface SinkSender {

    @Output(Sink.INPUT)
    MessageChannel output();
}
