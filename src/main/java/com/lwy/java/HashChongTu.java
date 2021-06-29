package com.lwy.java;


/**
 * create by: liuweiyi
 * description: TODO
 * create time: 2021/6/28 23:29
 * 模拟 hash冲突
  * @Param: null
 * @return
 */
public class HashChongTu {
    public static void main(String[] args) {
        String a = "Aa";
        String b = "BB";
        System.out.println(a.hashCode() == b.hashCode());

    }
}
