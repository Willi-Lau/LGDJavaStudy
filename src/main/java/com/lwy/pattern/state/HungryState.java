package com.lwy.pattern.state;

import javax.jws.soap.SOAPBinding;

public class HungryState implements GameState{
    @Override
    public void play() {
        System.out.println("饿！！！！！游戏输了");
    }

    @Override
    public GameState nextState() {
        return new BadState();
    }
}
