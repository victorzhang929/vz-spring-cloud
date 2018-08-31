package com.vz.spring.cloud.config.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangwei
 * @date 31/08/2018 10:42
 * @email victorzhang0929@hotmail.com
 */
@RestController
@RefreshScope
public class UserController {

    @Value("${from}")
    private String from;

    @Autowired
    private Environment environment;

    @GetMapping("/user/from")
    public String getFrom() {
        return this.from;
    }

    @GetMapping("/env/from")
    public String getEnvFrom() {
        return this.environment.getProperty("from");
    }
}
