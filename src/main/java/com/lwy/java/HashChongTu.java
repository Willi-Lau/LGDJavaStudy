package com.lwy.java;


import java.util.concurrent.ConcurrentHashMap;

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
        //System.out.println(a.hashCode() == b.hashCode());
        System.out.println(HashChongTu.q());

        ConcurrentHashMap map = new ConcurrentHashMap();

    }
    static String q(){
        try{
            System.out.println("begin");
            return "return !!!!!!";
        }
        finally{
            System.out.println("finally");
        }


    }

}
