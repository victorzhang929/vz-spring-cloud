package com.vz.eureka.client.consumer.service;

import java.util.List;

/**
 * @author zhangwei
 * @date 28/08/2018 20:46
 * @email victorzhang0929@hotmail.com
 */
public interface UserService {

    /**
     * 获取用户
     * @param username 用户名
     * @return 用户
     */
    String getUser(String username);

    /**
     * 获取所有用户
     * @param ids 用户ID数组
     * @return 所有用户
     */
    List<String> listUser(List<String> ids);
}
