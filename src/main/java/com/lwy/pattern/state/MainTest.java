package com.lwy.pattern.state;

public class MainTest {
    public static void main(String[] args) {
        //饿状态
        GameState state = new HungryState();
        Game game = new Game(state);
        game.playGame();
        //好状态
        GameState state2 = new GoodState();
        Game game2 = new Game(state2);
        game2.playGame();
        //坏状态
        GameState state3 = new BadState();
        Game game3 = new Game(state3);
        game3.playGame();
    }
}
