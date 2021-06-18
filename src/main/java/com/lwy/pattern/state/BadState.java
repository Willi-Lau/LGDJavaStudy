package com.lwy.pattern.state;

public class BadState implements GameState{
    @Override
    public void play() {
        System.out.println("坏状态！！！不打游戏");
    }

    @Override
    public GameState nextState() {
        return new GoodState();
    }
}
