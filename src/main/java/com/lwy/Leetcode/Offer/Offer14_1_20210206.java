package com.lwy.Leetcode.Offer;

/**
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 示例 1：
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * 示例 2:
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jian-sheng-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer14_1_20210206 {
    public static void main(String[] args) {
        Solution_offer14_1 offer141 = new Solution_offer14_1();
        int i = offer141.cuttingRope(10);
        System.out.println(i);
    }
}

/**
 * 思路，从切1刀到N刀依次计算  对于余数的处理是余数每一个都加到原来的结果上  e.g. 8/3 = 2 ...2  结果有三个2 余数是2 就把2加到3个2其中的两个2上变成 3 3 2
 */
class Solution_offer14_1 {
    public int cuttingRope(int n) {
        int max = 1;
        for (int i=1;i<=n;i++){
            //求出平均值
            int avg = n/(i+1);
            //求出余数
            int last = n %(i+1);
            int sum=1;
            //处理余数  余数平均分配
            for (int j=1;j<=last;j++){
                sum *= (avg+1);
            }
            for (int j=1;j<= i+1-last;j++){
                sum *= avg;
            }
             max = Math.max(sum, max);
        }
       return max;

    }
}