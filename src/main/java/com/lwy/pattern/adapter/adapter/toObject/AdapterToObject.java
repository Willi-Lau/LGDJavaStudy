package com.lwy.pattern.adapter.adapter.toObject;

import com.lwy.pattern.adapter.translator.Translator;
import com.lwy.pattern.adapter.translator.TranslatorDemo;
import com.lwy.pattern.adapter.watchtv.WatchTV;

/**
 * 通过这里用翻译器 增强电视播放器
 */
public class AdapterToObject implements WatchTV {

    WatchTV tv = null;
    Translator t = new TranslatorDemo();

    public AdapterToObject(WatchTV tv) {
        this.tv = tv;
    }

    @Override
    public String watch() {
        return  t.translator(tv.watch());
    }
}
