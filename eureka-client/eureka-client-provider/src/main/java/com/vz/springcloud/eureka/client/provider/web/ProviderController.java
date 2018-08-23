package com.vz.springcloud.eureka.client.provider.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangwei
 * @date 22/08/2018 20:53
 * @email victorzhang0929@hotmail.com
 */
@RestController
public class ProviderController {

    @GetMapping("/provider/user")
    public String getUser() {
        return "user";
    }
}
