package com.lwy.pattern.strategy;

/**
 * 游戏类 可以自己选择多种游戏算法
 */
public class Game {
    //不同游戏策略 注入游戏策略总接口 可以根据不同的实现 选择不同的策略
    private GameStrategy gameStrategy;
    //通过构造器注入
    public Game(GameStrategy gameStrategy) {
        this.gameStrategy = gameStrategy;
    }

    public void playGame(){
        System.out.println("游戏开始");
        //选择执行什么策略
        this.gameStrategy.gameStrategy();
        System.out.println("begin");
    }
}
