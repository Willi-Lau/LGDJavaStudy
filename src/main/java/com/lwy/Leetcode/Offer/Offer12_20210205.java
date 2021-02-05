package com.lwy.Leetcode.Offer;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 *
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 *
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 *
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer12_20210205 {

    public static void main(String[] args) {
        Solution_offer12 offer12 = new Solution_offer12();
        char[][] arr =new char[][]{{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','F'}};
        boolean abceseeefs = offer12.exist(arr, "ABCESEEEFS");
        System.out.println(abceseeefs);
    }
}


class Solution_offer12 {
     int m;
     int n;

     char[] chars;
     int slong;

    public boolean exist(char[][] board, String word) {

          this.m =  board.length;
          this.n = board[0].length;

          this.chars = word.toCharArray();
          this.slong = word.length();
            //遍历集合
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                //每次都是新的顺序

                if (istrue(i, j, board,0))
                    return true;

            }
        }

        return false;


    }

    public  boolean istrue(int i,int j,char[][] arr,int t){

        //不符合条件直接返回 || flag[i][j] == true
        if(i >= m ||  j >= n || i <0 || j <0  || arr[i][j] != chars[t]){

            return false;
        }
        //如果t 遍历到最后一个了，就是正确的
        if( t == slong -1){
            return true;
        }


        //返回向上下左右 四个方向的结果
//        boolean left = false;
//        boolean top = false;
//        boolean right = false;
//        boolean bottom = false;
        //[i][j]    [m][n]
//设置为空字符串之后的还原步骤非常关键，假设在最后的分支遇到失败情况，可以再次回溯查找，不会影响其它方向的执行结果
                arr[i][j] = ' ';
//                //左
//                if( j >= 1) {
//                     left = istrue(i , j-1, arr, t + 1);
//                }
//                //右
//                if( j < n -1) {
//                     right = istrue(i , j+ 1, arr, t + 1);
//                  }
//                //下
//                if( i < m -1 ) {
//                    bottom = istrue(i + 1, j, arr, t + 1);
//                }
//                //上
//                if( i >= 1) {
//                    top = istrue(i -1, j , arr, t + 1);
//                }
      //  boolean fuck = top || left || right || bottom;    低效率
        boolean fuck =  istrue(i , j-1, arr, t + 1) ||
                        istrue(i , j+ 1, arr, t + 1) ||
                        istrue(i + 1, j, arr, t + 1) ||
                        istrue(i -1, j , arr, t + 1);
        arr[i][j] = chars[t];
        return fuck;







    }
}


























