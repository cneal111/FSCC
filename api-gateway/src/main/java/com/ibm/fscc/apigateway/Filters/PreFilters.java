package com.ibm.fscc.apigateway.Filters;

import com.netflix.zuul.ZuulFilter;

public class PreFilters extends ZuulFilter {

    @Override
    public Object run() {
        return null;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public String filterType() {
        return "pre";
    }
    
}
