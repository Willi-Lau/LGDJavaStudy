package com.lwy.pattern.strategy;

public class KillGameStrategy implements GameStrategy{
    @Override
    public void gameStrategy() {
        System.out.println("杀人！！！！！！");
    }
}
