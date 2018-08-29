package com.vz.spring.cloud.client.feign.controller;

import com.vz.spring.cloud.client.feign.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangwei
 * @date 29/08/2018 16:34
 * @email victorzhang0929@hotmail.com
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/feign/{username}")
    public String getUser(@PathVariable("username") String username) {
        return userService.getUser(username);
    }
}
