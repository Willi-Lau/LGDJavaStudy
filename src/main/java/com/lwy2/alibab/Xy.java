package com.lwy2.alibab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 小强发现当已知以及时,能很轻易的算出的值.但小强想请你在已知 和的情况下,计算出的值.因为这个结果可能很大,所以所有的运算都在模1e9+7下进行.
 *
 * 输入描述:
 * 第一行输入一个正整数.表示有组数据
 * 接下来行,每行输入三个整数,和.
 *
 *
 *
 *
 * 输出描述:
 * 输出行,每一行表示每组数据的结果.
 *
 * 输入例子1:
 * 3
 * 4 4 3
 * 2 3 4
 * 5 2 6
 *
 输出例子1:
 16
 999999993
 9009
 */
public class Xy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();

        
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        List<Integer> output = new ArrayList<Integer>();
        for (int num : nums) {
            output.add(num);
        }

        int n = nums.length;
        backtrack(n, output, res, 0);//   1 2 3 4   --> 4
        return res;
    }
    public void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        // 所有数都填完了
        if (first == n) {
            res.add(new ArrayList<Integer>(output));
        }
        for (int i = first; i < n; i++) {   //0  0-1
            // 动态维护数组
            Collections.swap(output, first, i);  // 0 0
            // 继续递归填下一个数
            backtrack(n, output, res, first + 1); // 1
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }



}
