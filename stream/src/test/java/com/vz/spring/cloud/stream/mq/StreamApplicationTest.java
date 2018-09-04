package com.vz.spring.cloud.stream.mq;

import com.vz.spring.cloud.steam.StreamApplication;
import com.vz.spring.cloud.steam.mq.SinkSender;
import com.vz.spring.cloud.steam.mq.integrate.SinkSenderIntegrate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author zhangwei
 * @date 04/09/2018 11:36
 * @email victorzhang0929@hotmail.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = StreamApplication.class)
public class StreamApplicationTest {

    @Autowired
    private SinkSender sinkSender;

//    @Autowired
//    private MessageChannel input;

    @Test
    public void contextLoader() {
//        MessageChannel messageChannel = sinkSender.output();
        sinkSender.output().send(MessageBuilder.withPayload("From SinkSender").build());
    }


    @Test
    public void contextLoaderIntegrate() {
        SinkSenderIntegrate sinkSenderIntegrate = new SinkSenderIntegrate();
        sinkSenderIntegrate.timeMessageSource();
    }

}
