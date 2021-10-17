package com.lwy2.beikemaifang;

/**
 问题 3、
 问题描述:
 给出三个整数 a，b，c，你需要计算数2𝑎 + 2𝑏 − 2𝑐在二进制表示下 1 的个数。
 输入描述：
 第一行包含三个整数a，b，c。1 ≤ c < b < a ≤ 109
 输出描述:
 输出对应的答案。
 输入样例：
 3 2 1
 输出样例：
 2
 样例解释：
 23 + 22 − 21 = 10 = (1010)2
 */
public class ErJinZhiShu {

    public static void main(String[] args) {
       int a = 3;
       int b = 2;
       int c = 1;
        double v = Math.pow(2, 3) + Math.pow(2, 2) - Math.pow(2, 1);
        String[] split = Double.toString(v).split("\\.");
        int i = Integer.parseInt(split[0]);
        char[] arr = Integer.toBinaryString(i).toCharArray();
        int sum = 0;

        for(char p:arr){
            if(p == '1'){
                sum ++;
            }
        }

        System.out.println(sum);
    }

    }
