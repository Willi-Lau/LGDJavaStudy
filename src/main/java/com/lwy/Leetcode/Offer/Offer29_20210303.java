package com.lwy.Leetcode.Offer;

/**
 * 剑指 Offer 29. 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *
 *
 *
 * 示例 1：
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 *
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class Offer29_20210303 {
    public static void main(String[] args) {
        Solution_offer29 offer = new Solution_offer29();
        int[][] arr = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        offer.spiralOrder(arr);
    }
}

/**首先获取矩阵长，宽 然后 左-》右 右-》下 下-》左 左-》上为一圈 一直走直到矩阵所有元素被走完
 * 思路：
 */
class Solution_offer29 {
    public void spiralOrder(int[][] matrix) {
        boolean[][] matrix1 = new boolean[matrix.length][matrix[0].length];
        //右边界
        int right = matrix[0].length - 1;
        //下边界
        int bottom = matrix.length - 1;
        //左边界
        int left = 0;
        //上边界
        int top = 0;
        //总步数
        int max = (right + 1) * (bottom+1);
        //此时得坐标
        int x=0,y=0;
        int f =0;

        //System.out.println(matrix[x][y]);
        while (true){
            //
            //向右
            for(int i = left ; i < right ; i++){



                    y++;
                    f++;
                System.out.println(matrix[x][y]);

            }


            //向下
            for(int i = top; i < bottom ; i++){


                    x++;
                    f++;

                System.out.println(matrix[x][y]);
            }


            //向左
            for(int i = right ; i > left ; i--){


                    y--;
                    f++;
                System.out.println(matrix[x][y]);

            }

            //向上
            for(int i = bottom ; i > top ; i--){

                x--;
                f++;
                System.out.println(matrix[x][y]);

            }

            //左下表 +1
            left ++;
            //下边界 -1
            bottom --;
            //右边界 -1
            right --;
            //上边界+1
            top ++;



            if(f == max){

                break;
            }



        }

    }
}
