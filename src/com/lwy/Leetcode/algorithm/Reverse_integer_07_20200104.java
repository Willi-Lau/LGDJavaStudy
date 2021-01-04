package com.lwy.Leetcode.algorithm;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Reverse_integer_07_20200104 {

    public static void main(String[] args) {
        Solution_07 solution_07 = new Solution_07();
        System.out.println(solution_07.reverse(123));
    }
}
class Solution_07 {
    public int reverse(int x) {
        int l = Integer.toString(x).length();

        long newx = (long) (x / Math.pow(10,l-1));


        for (int i = 2;i <= l;i++){


            newx = (long) Math.pow(10,l-(i-1)) * (x % 10) + newx;
            x = x / 10;
        }

        if(newx<0){
            newx = newx / 10;
        }
        if (newx != (int)newx){
            newx = 0;
        }

        return  (int)newx;
    }
}