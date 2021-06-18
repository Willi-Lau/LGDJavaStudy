package com.lwy.pattern.strategy;

public class MainTest {
    public static void main(String[] args) {
        Game game = new Game(new RunGameStrategy());//传入逃跑策略
        game.playGame();  //执行游戏
    }
}
