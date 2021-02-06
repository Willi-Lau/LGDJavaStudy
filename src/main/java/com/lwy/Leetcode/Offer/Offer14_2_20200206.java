package com.lwy.Leetcode.Offer;

/**
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m - 1] 。请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 *  
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
 * 链接：https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer14_2_20200206 {
    public static void main(String[] args) {
        
    }
}

/**
 * 思路：和14-1不同的是对结果处取模
 */
class Solutionoffer14_2 {
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
            sum %= 1000000007;
            max = Math.max(sum, max);
        }
        return max;

    }
}
