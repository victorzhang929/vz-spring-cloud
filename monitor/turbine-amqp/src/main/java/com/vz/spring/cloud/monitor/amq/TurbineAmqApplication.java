package com.vz.spring.cloud.monitor.amq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;

/**
 * @author zhangwei
 * @date 29/08/2018 16:08
 * @email victorzhang0929@hotmail.com
 */
@SpringBootApplication
@EnableTurbineStream
public class TurbineAmqApplication {

    public static void main(String[] args) {
        SpringApplication.run(TurbineAmqApplication.class, args);
    }
}
