package com.lwy2.didi;

public class FanzhuanDanCi {
    public static void main(String[] args) {
        String s = "123456";
        char[] test = test(s);
        System.out.println(test);
    }

    public static char[] test(String s){
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length -1;
        while (left < right){
            char a = chars[left];
            chars[left] = chars[right];
            chars[right] = a;
            left ++;
            right --;
        };

        return chars;


    }
}
