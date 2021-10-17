package com.lwy2.alibab;

import java.util.*;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 *
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出：[[1]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Quanpailie {

    public static void main(String[] args) {
        int[] x = {1,2,3,4,5};
        int[] y = {6,7,8,9,10};
        for (int i:x){
            System.out.println("--------------"+i);
            for (int j:y){
                System.out.println(j);
                if(j == 8){
                    System.out.println("*****************");
                    break;
                }
            }
        }
//        int[] x = {3,2,1};
//        List<List<Integer>> father = new ArrayList<List<Integer>>();
//        List<Integer> son = new ArrayList<>();
//        for (int i:x){
//            son.add(i);
//        }
//
//        String s = "";
//        Scanner sc =  new Scanner(System.in);
      
//        back(son.size(),son,father,0);
//        for (List<Integer> list :father) {
//            System.out.println(list);
//        }
//
//        long l = System.currentTimeMillis();
//        System.out.println(new Date(l));


//        for (int i:son){
//            System.out.println(i);
//        }
    }

    public static void back(int n,  List<Integer> son, List<List<Integer>> father ,int first){
        if(first == n){
            father.add(new ArrayList<>(son));
        }

        for (int i=first;i<n;i++){
            Collections.swap(son,first,i);
            back(n,son,father,first+1);
            Collections.swap(son,first,i);
        }
    }
}
