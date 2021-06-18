package com.lwy.pattern.state;

public interface GameState {
    //玩游戏
    void play();
    //切换到下一个状态
    GameState nextState();

}
