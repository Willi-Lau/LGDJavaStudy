package com.lwy2.didi;

import java.util.Arrays;
import java.util.List;

public class QuickSort {
    public static void main(String[] args) {
             int[] arr = {9,8,5,6,1,5,7,8};
             test(arr,0,arr.length-1);

        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }


    public static void test(int[] arr,int left,int right){
        if(left > right){
            return;
        }

        int flag = arr[left];
        int i = left;
        int j = right;
        while (i != j){
            while (arr[j]>=flag && i<j){
                j--;
            }
            while (arr[i]<=flag && i<j){
                i++;
            }
            if(i < j){
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }

        }

        int m = arr[i];
        arr[i] = arr[left];
        arr[left] = m;

        test(arr,left,i-1);
        test(arr,i+1,right);

    }
}
