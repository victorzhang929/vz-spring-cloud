package com.vz.spring.cloud.client.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zhangwei
 * @date 29/08/2018 16:30
 * @email victorzhang0929@hotmail.com
 */
@FeignClient(value = "eureka-provider")
public interface UserService {

    /**
     * 获取用户
     * @param username 用户名
     * @return 用户
     */
    @GetMapping("/provider/{username}")
    String getUser(@PathVariable("username") String username);
}
