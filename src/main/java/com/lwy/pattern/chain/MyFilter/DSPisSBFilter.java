package com.lwy.pattern.chain.MyFilter;

import com.lwy.pattern.chain.Filter.MyChain;
import com.lwy.pattern.chain.Filter.MyFilter;
import com.lwy.pattern.chain.Filter.MyRequest;
import com.lwy.pattern.chain.Filter.MyResponse;

public class DSPisSBFilter implements MyFilter {
    @Override
    public void doFilter(MyRequest req, MyResponse resp, MyChain chain) {
        System.out.println("--------------进入DSPisSBFilter");
        chain.doFilter(req,resp,chain);
        System.out.println("--------------走出DSPisSBFilter");
    }
}
