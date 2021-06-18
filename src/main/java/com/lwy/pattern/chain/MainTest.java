package com.lwy.pattern.chain;

import com.lwy.pattern.chain.Filter.MyChain;
import com.lwy.pattern.chain.Filter.MyRequest;
import com.lwy.pattern.chain.Filter.MyResponse;
import com.lwy.pattern.chain.MyFilter.DSPisSBFilter;
import com.lwy.pattern.chain.MyFilter.ExceptionFilter;
import com.lwy.pattern.chain.MyFilter.HttpFilter;

public class MainTest {
    public static void main(String[] args) {
        MyChain myChain = new MyChain();
        myChain.addFilter(new ExceptionFilter());
        myChain.addFilter(new HttpFilter());
        myChain.addFilter(new DSPisSBFilter());

        myChain.doFilter(new MyRequest("12"),new MyResponse("34"),myChain);
    }
}
