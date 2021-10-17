package com.lwy.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ErFen {
    public static void main(String[] args) {

        int[] arr = {1,2,4,5,6,7};
        int key = 7;
        System.out.println(test(arr,7,0,arr.length - 1));

        List<int[]> ints = Arrays.asList(arr);
       
    }


    public static int test(int[] arr,int key,int min,int max){
        if(min > max || arr[min] > key || arr[max] < key){
            return -1;
        }

        int middle = arr[(max+min) /2];

        if(key < middle){
            return test(arr,key,min,(max+min)/2 - 1);
        }
        else if(key > middle){
            return test(arr,key,(max+min)/2 + 1,max);
        }
        else {
            return (max+min) /2;
        }




    }

}


