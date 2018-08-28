package com.vz.eureka.client.consumer.web;

import com.vz.eureka.client.consumer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangwei
 * @date 22/08/2018 20:59
 * @email victorzhang0929@hotmail.com
 */
@RestController
public class ConsumerController {

    @Autowired
    private UserService userService;

    @GetMapping("/consumer/{username}")
    public String getUserByProvider(@PathVariable("username") String username) {
        return userService.getUser(username);
    }
}
