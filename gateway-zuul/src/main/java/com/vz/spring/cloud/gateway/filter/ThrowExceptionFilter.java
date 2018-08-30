package com.vz.spring.cloud.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * @author zhangwei
 * @date 30/08/2018 15:51
 * @email victorzhang0929@hotmail.com
 */
@Component
public class ThrowExceptionFilter extends ZuulFilter {

    private static final Logger logger = LoggerFactory.getLogger(ThrowExceptionFilter.class);

    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return -1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        logger.info("this is pre type filter");
        throwException();
        return null;
    }

    private void throwException() {
        throw new RuntimeException("Exist some errors");
    }
}
