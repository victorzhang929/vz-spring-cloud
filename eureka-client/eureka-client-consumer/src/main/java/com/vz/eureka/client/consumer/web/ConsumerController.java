package com.vz.eureka.client.consumer.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhangwei
 * @date 22/08/2018 20:59
 * @email victorzhang0929@hotmail.com
 */
@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/user")
    public String getUserByProvider() {
        return restTemplate.getForObject("http://EUREKA-PROVIDER/provider/user", String.class);
    }
}
