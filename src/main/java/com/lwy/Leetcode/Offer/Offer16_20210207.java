package com.lwy.Leetcode.Offer;

/**
 * 实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 *
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 *
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 *  
 *
 * 说明:
 *
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer16_20210207 {

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }
}


class Solution_offer16 {
    /**
     * 这题看起来很简单，但能一步写成功很不容易，我们先来分析下。
     *
     * 当exponent是0的时候，直接返回1即可，
     *
     * 当exponent小于0的时候，需要把它转化为正数才能更方便计算，同时base要变为1/base。
     *
     * 当exponent大于0的时候要分为两种情况，一种是偶数，一种是奇数。
     *
     * 1， 如果exponent是偶数我们只需要计算
     *
     * Power(base*base, exponent/2)。举个例子，比如我们要计算Power（3，8），我们可以改为
     * Power（3*3，8/2），也就是Power（9，4）。
     *
     * 2， 如果exponent是奇数，我们只需要计算
     *
     * base*Power(base*base, exponent/2)，比如Power（3，9），我们只需要计算3*Power（3*3，9/2），也就是3*Power（9，4）。
     *
     */
    public double myPow(double x, int n) {
        long m = n;
        return myPow_plus(x,m);

    }

    public double myPow_plus(double x,long n){
        if(n==0) return 1;
        if (n == 1) return x;
        if(n<0) return myPow_plus(1/x,-n);

        if( n%2 == 0){
            return myPow_plus(x*x,n/2);
        }
        else {
            return x*myPow_plus(x*x,n/2);
        }
    }

    /**
     * 这种方法回暖超时
     * @param x
     * @param n
     * @return
     */
    public double myPow2(double x, int n) {
        double sum = 1;
        long nn = n;
        if(nn == 0) return 1;
        if(nn == 1) return x;
        if(nn == -1) return 1/x;
        if(x == 1.0000) return 1;

        if(n<0){
            x = 1/x;
            nn = -nn;

        }



        while(nn >0){
            sum = sum * x;
            nn -= 1;
        }

     return sum;

    }}


