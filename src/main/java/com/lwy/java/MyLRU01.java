package com.lwy.java;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class MyLRU01 {
}

class MyLRU extends LinkedHashMap {

    private final int CACHE_SIZE;

    public MyLRU(int cachesize){
        super((int)Math.ceil(cachesize/0.75)+1,0.75f,true);
        CACHE_SIZE = cachesize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > CACHE_SIZE;
    }
}
