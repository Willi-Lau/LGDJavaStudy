package com.lwy2.didi;

import java.util.Arrays;

public class QuickSort2 {

    public static void main(String[] args) {
        int[] a = {1,3,5,4,2,1,6,9,5};
        quick(a,0,a.length-1);
        for (int i:a){
            System.out.print(i);
        }
    }

    public static void quick(int[] arr,int left,int right){
        if(left>right){
            return;
        }
        int i = left;
        int j = right;
        int flag = arr[left];
        while(i != j){

            while(flag<=arr[j]&& i<j){
                j--;
            }
            while (flag >=arr[i]&&i<j) {
                i++;
            }
            if(i<j){
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }

        int t = arr[i];
        arr[i] = arr[left];
        arr[left] = t;

        quick(arr,left,i-1);
        quick(arr,i+1,right);
    }
}
