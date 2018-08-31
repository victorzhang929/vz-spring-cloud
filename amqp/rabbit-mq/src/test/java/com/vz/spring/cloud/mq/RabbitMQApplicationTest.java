package com.vz.spring.cloud.mq;

import com.vz.spring.cloud.mq.producter.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author zhangwei
 * @date 31/08/2018 17:46
 * @email victorzhang0929@hotmail.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RabbitMQApplicationTest {

    @Autowired
    private Sender sender;

    @Test
    public void testSend() {
        sender.send();
    }
}
