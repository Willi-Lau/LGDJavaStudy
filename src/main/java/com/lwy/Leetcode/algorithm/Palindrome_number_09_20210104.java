package com.lwy.Leetcode.algorithm;

/**
 *
 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

 示例 1:

 输入: 121
 输出: true
 示例 2:

 输入: -121
 输出: false
 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 示例 3:

 输入: 10
 输出: false
 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 */
public class Palindrome_number_09_20210104 {

    public static void main(String[] args) {
        Solution09 solution09 = new Solution09();
        System.out.println(solution09.isPalindrome(1));

    }
}
class Solution09 {
    public boolean isPalindrome(int x) {
        boolean number = false ;
        int l =Integer.toString(x).length();

        if (x >0 && l>1){
            String s = Integer.toString(x);
            String s1 ="";
            String s2= "";
            if(l%2 != 0){
                 s1 = s.substring(0, (l / 2));
                 s2 = s.substring((l / 2)+1,l);
            }
            else {
                s1 = s.substring(0, (l / 2));
                s2 = s.substring((l / 2),l);
            }
            String stringBuffer = new StringBuffer(s1).reverse().toString();
            if(Integer.parseInt(stringBuffer)==Integer.parseInt(s2)){
                number = true;
            }
        }
        if(l == 1){
            number = true;

        }
        return number;
    }
}
