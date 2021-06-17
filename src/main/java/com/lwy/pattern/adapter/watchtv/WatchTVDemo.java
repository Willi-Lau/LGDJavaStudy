package com.lwy.pattern.adapter.watchtv;

/**
 * 这里是电视播放器
 */
public class WatchTVDemo implements WatchTV{

    @Override
    public String watch() {
        String chinese = "哈哈哈哈";
        System.out.println("电视在播放节目");
        return chinese;
    }
}
