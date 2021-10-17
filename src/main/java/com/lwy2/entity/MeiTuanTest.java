package com.lwy2.entity;

import java.util.*;

public class MeiTuanTest {
    public static void main(String[] args) {
     int[] arr = new int[]{1,2,3,4,5,6,7,8,9};
     int[] arr2 = new int[arr.length-1];
     int k = 3 - 1;
     int i = 0;
     int j = 0;
     while (i < arr.length){
            if(!(i == k)){
                arr2[j] = arr[i];
                j++;
                i++;
            }
            else {
                i++;
            }
        }
     for(int m : arr2){
         System.out.print(m+" ");
     }

    }
}






class TreeNode1{

        public int val;
        public TreeNode1 left;
        public TreeNode1 right;
        public TreeNode1() {}
        public TreeNode1(int val) { this.val = val; }
        public TreeNode1(int val, TreeNode1 left, TreeNode1 right) {
            this.val = val;
            this.left = left;
            this.right = right;

        }

}
