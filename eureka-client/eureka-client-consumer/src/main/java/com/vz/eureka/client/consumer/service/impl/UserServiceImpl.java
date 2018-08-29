package com.vz.eureka.client.consumer.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.vz.eureka.client.consumer.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author zhangwei
 * @date 28/08/2018 20:47
 * @email victorzhang0929@hotmail.com
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    @HystrixCommand(fallbackMethod = "getUserByProviderBack")
    public String getUser(String username) {
        return restTemplate.getForObject("http://EUREKA-PROVIDER/provider/{username}", String.class, username);
    }

    public String getUserByProviderBack(String username) {
        return username + ": error";
    }

    @Override
    public List<String> listUser(List<String> ids) {
        return restTemplate.getForObject("http://EUREKA-PROVIDER/provider/{username}", List.class, StringUtils.join(ids, ","));
    }

}
