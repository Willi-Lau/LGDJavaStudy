package com.lwy.Leetcode.Offer;

/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 *  
 *
 * 示例:
 *
 * 现有矩阵 matrix 如下：
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 *
 * 给定 target = 20，返回 false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer04_20210124 {
    public static void main(String[] args) {

    }
}

/**
 * 思路：从右上角开始，和target比较，如果相同，就返回，如果比target大，就往左找，比target小，就往下找
 */
class Solution_offer04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null && matrix.length == 0){
            return false;
        }
        else {
            //首先定义边界
            int x = matrix[0].length;
            int y = matrix.length;
            //定义浮动的x y
            int mx = x - 1;
            int my = 0;
            //最多执行的次数
            int all = (x) * (y);
            //执行的次数
            int flag = 1;
            while(flag <= all){
                if(matrix[my][mx] == target){
                    flag = -100;
                    break;
                }
                else if( matrix[my][mx] < target && my < y - 1){
                    my++;
                }
                else if(matrix[my][mx] > target && mx > 1){
                    mx--;
                }

                flag++;
            }

            //判断是否存在
            if(flag < 0){
                return true;
            }
            else {
                return false;
            }

        }

    }
}