package com.lwy.pattern.adapter.translator;

/**
 * 这里是翻译器
 */
public class TranslatorDemo implements Translator{
    @Override
    public String translator(String chinese) {
        String english = null;
        if(chinese.equals("哈哈哈哈")){
            english = "hhhhh";

        }
        else {
            english = "shabi";
        }
        System.out.println(english);
        return english;
    }
}
