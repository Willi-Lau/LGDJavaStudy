package com.lwy.pattern.adapter.adapter.toClass;

import com.lwy.pattern.adapter.translator.TranslatorDemo;
import com.lwy.pattern.adapter.watchtv.WatchTV;

/**
 * 通过这里用翻译器 增强电视播放器
 */
public class AdapterToClass extends TranslatorDemo implements WatchTV{
    private WatchTV watchTV;
    @Override
    public String watch() {
        return translator(watchTV.watch());     //适配器的核心 通过继承来实现
    }

    public AdapterToClass(WatchTV watchTV) {
        this.watchTV = watchTV;
    }
}
