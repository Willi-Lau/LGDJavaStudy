package com.lwy.study202105.java;


/**
 * 有n个台节一次只能上 1节或2节 求多少种上法
 *
 * 分析：
 *      n=1    1
 *      n=2    1+1 或  2
 *      n=3    n=1 基础上再上 2节 或  n=2基础上再上1节    n=1 + n=2
 *      n=4    n=2 基础上再上 2节 或  n=3基础上再上1节    n=2 + n=3
 *
 *      .....
 *
 *      n      n = n-1 上1   或    n = n-2 上 2
 */
public class JavaRecursion {
    public static void main(String[] args) {
        System.out.println(up(4));
    }

    public static int up(int n){
        if(n == 1 || n == 2){
            return n;
        }
        return up(n-1)+up(n-2);
    }
}
