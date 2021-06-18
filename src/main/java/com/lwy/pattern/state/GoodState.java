package com.lwy.pattern.state;

import javax.jws.soap.SOAPBinding;

public class GoodState implements GameState{
    @Override
    public void play() {
        System.out.println("好状态！！！！！游戏赢了");
    }

    @Override
    public GameState nextState() {
        return new HungryState();
    }
}
