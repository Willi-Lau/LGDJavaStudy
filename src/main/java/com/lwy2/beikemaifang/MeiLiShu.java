package com.lwy2.beikemaifang;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import java.util.HashMap;
import java.util.Scanner;

/**

 问题描述：
 对于一个非负整数我们称它是美丽的当且仅当它的十进制表示下不包含多个相同的数字。比如1234，7523 都是美丽的，但99，121，3043等都不是美丽的。现在给出一个数字n，你需要找到比n大的，最小的美丽的数。
 输入描述：
 第一行包含一个整数n。1000≤n≤9000
 输出描述：
 输出对应的答案，若不存在满足条件的数，输出-1。
 输入样例1：
 1987
 输出样例1：
 2013
 输入样例2：
 2013
 输出样例2：
 2014
 */
public class MeiLiShu {

    public static void main(String[] args) {
    //    Scanner sc = new Scanner(System.in);
    //    int num = sc.nextInt();
        System.out.println(test(2013));
    }


    public static int test(int num){
        int flag = ++num;
        while (true){
            if(isBeautify(flag)){
                return flag;
            }
            else {
                flag ++;
            }
        }

    }

    public static boolean isBeautify(int num){
        HashMap map = new HashMap();
        String string = Integer.toString(num);
        char[] chars = string.toCharArray();
        for (char c : chars){
            if(map.containsKey(c)){
                return false;
            }
            else {
                map.put(c,1);
            }
        }

        return true;


    }
}
