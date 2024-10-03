package com.example.OssComponent.Zuul;

import org.slf4j.LoggerFactory;

public class PreLogginFilter  extends ZuulFilter{

    private static final Logger logger = LoggerFactory.getLogger(PreLogginFilter.class)
    @Override
    public String filterType(){

        return "pre";
    }

    public Object run(){

        RequestContext ctx = RequestContext.getCurrentContext();
        logger.info("Request Method" + ctx.getRequest().getMethod());
        logger.info("Request uel" + ctx.getRequest().getRequestUrl().toString());
    }
}
