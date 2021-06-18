package com.lwy.pattern.state;
/**
 * create by: liuweiyi
 * description: TODO
 * create time: 2021/6/18 12:28
 * 状态模式 不同的状态会对游戏产生不同的结果
  * @Param: null
 * @return
 */
public class Game {
//    不同的状态
    private GameState state;

    public Game(GameState state) {
        this.state = state;
    }

    public void playGame(){
        //不同的状态 玩游戏也不一样
        this.state.play();
    }

    public void nextState(){
        //切换到下一个状态
        this.state = this.state.nextState();
    }
}
