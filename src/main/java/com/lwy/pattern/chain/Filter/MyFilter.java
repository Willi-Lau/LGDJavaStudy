package com.lwy.pattern.chain.Filter;

public interface MyFilter {

    void doFilter(MyRequest req,MyResponse resp,MyChain chain);
}
