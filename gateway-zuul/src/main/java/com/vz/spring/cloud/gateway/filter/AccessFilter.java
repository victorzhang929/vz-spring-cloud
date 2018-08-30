package com.vz.spring.cloud.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * @author zhangwei
 * @date 30/08/2018 13:42
 * @email victorzhang0929@hotmail.com
 */
//@Component
public class AccessFilter extends ZuulFilter {

    private static final Logger logger = LoggerFactory.getLogger(AccessFilter.class);

    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    /**
     * 过滤器中执行顺序，数值越小优先级越高
     * @return 执行顺序
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 过滤器是否需要被执行，true是对所有的请求都过滤，这里可以加入业务逻辑针对不同范围进行过滤
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();

        logger.info("send {} request to {}", request.getMethod(), request.getRequestURL().toString());
        String token = request.getParameter("token");
        if (null == token) {
            logger.warn("access token is empty");
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);
            return null;
        }

        logger.info("access successful");
        return null;
    }
}
