package com.vz.eureka.client.consumer.service.impl;

import com.netflix.hystrix.HystrixCommand;
import com.vz.eureka.client.consumer.service.UserService;

import java.util.List;

import static com.netflix.hystrix.HystrixCommandGroupKey.Factory.asKey;

/**
 * @author zhangwei
 * @date 29/08/2018 11:43
 * @email victorzhang0929@hotmail.com
 */
public class UserBatchCommand extends HystrixCommand<List<String>> {
    private UserService userService;
    private List<String> userIds;

    public UserBatchCommand(UserService userService, List<String> userIds) {
        super(Setter.withGroupKey(asKey("userServiceCommand")));
        this.userService = userService;
        this.userIds = userIds;
    }

    @Override
    protected List<String> run() throws Exception {
        return userService.listUser(userIds);
    }

}
