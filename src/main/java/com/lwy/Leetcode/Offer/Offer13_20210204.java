package com.lwy.Leetcode.Offer;

/**
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 *  
 *
 * 示例 1：
 *
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 2：
 *
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer13_20210204 {

    public static void main(String[] args) {
        Solution_offer13 offer13 = new Solution_offer13();
        int i = offer13.movingCount(16, 8, 4);

        System.out.println(i);
    }
}

/**
 * 思路：要注意 10是算成 1+0 所以如果9过不去 10可能能过去
 *       利用迭代思想 从0,0开始依次遍历 遍历自己右边和下面两个位置判断是否符合
 */
class Solution_offer13 {
    int flag = 0;
    int m,n,k;
    boolean[][] arr;
    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
         this.arr = new boolean[m][n];
        //调用判断

        count(0,0);

        return flag;
    }


    public  void count(int x,int y){
            //求出数位和
            int sum_x = 0;
            int sum_y = 0;
            sum_x += (x%10)+(x/10%10)+(x/100);
            sum_y += (y%10)+(y/10%10)+(y/100);
            //符合条件 ++
            if(x<m && y<n &&sum_x + sum_y <=k&& arr[x][y] == false ){
                flag ++;
                System.out.println("x:"+x+" y:"+y+arr[x][y]);
                //记录已经走过
                arr[x][y] = true;
            }
            //不符合别的也不用判断了
            else {
                //记录已经走过
                arr[x][y] = true;
                return;
            }


            //判断右
            if(x<m-1)
            count(x+1,y);
            //判断下
            if(y<n-1)
            count(x,y+1);
    }
}