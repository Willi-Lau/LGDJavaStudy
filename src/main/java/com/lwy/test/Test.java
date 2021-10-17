package com.lwy.test;


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

public class Test {


    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,7,8};
        int test = test(arr, 0, arr.length, 6);
        System.out.println(test);
    }


    public static int test(int[] arr,int left,int right,int key){
        int mid = (left + right)/2;
       if(key < arr[left] && key > arr[right] && left > right)return -1;
        if(key < arr[mid]){
            return test(arr,left,mid-1,key);
        }
        else if(key > arr[mid]){
            return test(arr,mid+1,right,key);
        }
        else {
            return mid;
        }


    }
}


class Nell{

}
