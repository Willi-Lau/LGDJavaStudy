package com.lwy.Leetcode.Offer;

/**
 * 剑指 Offer 10- II. 青蛙跳台阶问题
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 */
public class Offer10_2_20210126 {
}

/**
 * 思路 f0 =1 f1 = 1  f2 = 2 f3 = 3  f4 = 5 ...斐波那契
 * 跳n个台节 最后一次可能跳一次 有 f(n-1) 种跳法 也可能跳两次 有f(n-2)次跳法 所以 f(n) = f(n-1) + f(n-2)
 */

class Solution_offer10_2 {
    public int numWays(int n) {
        int f0 = 1;
        int f1 = 1;
        int f2 = 2;
        if( n == 0 || n == 1){
            return 1;
        }
        else {
            for (int i=2;i<=n;i++){
                f2 = f0 + f1;
                f2 %= 1000000007;
                f0 = f1;
                f1 = f2;
            }
            return f2;
        }

    }
}