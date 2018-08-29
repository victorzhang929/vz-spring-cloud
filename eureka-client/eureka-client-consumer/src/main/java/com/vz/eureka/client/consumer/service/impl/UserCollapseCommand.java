package com.vz.eureka.client.consumer.service.impl;

import com.netflix.hystrix.HystrixCollapser;
import com.netflix.hystrix.HystrixCollapserProperties;
import com.netflix.hystrix.HystrixCommand;
import com.vz.eureka.client.consumer.service.UserService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static com.netflix.hystrix.HystrixCollapserKey.Factory.asKey;

/**
 * @author zhangwei
 * @date 29/08/2018 11:46
 * @email victorzhang0929@hotmail.com
 */
public class UserCollapseCommand extends HystrixCollapser<List<String>, String, String> {


    private UserService userService;
    private String userId;

    public UserCollapseCommand(UserService userService, String userId) {
        super(Setter.withCollapserKey(asKey("userCollapseCommand")).andCollapserPropertiesDefaults(
                HystrixCollapserProperties.Setter().withTimerDelayInMilliseconds(100)
        ));
        this.userService = userService;
        this.userId = userId;
    }

    @Override
    public String getRequestArgument() {
        return userId;
    }

    @Override
    protected void mapResponseToRequests(List<String> batchResponse, Collection<CollapsedRequest<String, String>> collapsedRequests) {
        int count = 0;
        for (CollapsedRequest<String, String> collapsedRequest : collapsedRequests) {
            String user = batchResponse.get(count);
            collapsedRequest.setResponse(user);
        }
    }

    @Override
    protected HystrixCommand<List<String>> createCommand(Collection<CollapsedRequest<String, String>> collapsedRequests) {
        List<String> userIds = new ArrayList<>(collapsedRequests.size());
        userIds.addAll(collapsedRequests.stream().map(CollapsedRequest::getArgument).collect(Collectors.toList()));
        return new UserBatchCommand(userService, userIds);
    }
}
