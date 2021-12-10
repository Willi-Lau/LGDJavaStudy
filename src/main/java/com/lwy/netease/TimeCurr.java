package com.lwy.netease;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;

public class TimeCurr {

    public static void main(String[] args) {

        boolean matches = Pattern.matches("^(\\-|\\+)?\\d+(\\.\\d+)?$", "15.6");
        System.out.println(matches);

    }

    public static void  findMaxNum1(int[] arr,int num){
        quickSort(arr,0,arr.length-1);
        for (int i = arr.length - num;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    public static void quickSort(int[] arr,int left,int right){
        if(left > right){
            return;
        }
        int i = left;
        int j = right;
        int flag = arr[left];
        while (i != j){
            while (arr[j] >= flag && i < j){
                j--;
            }
            while (arr[i] <= flag && i < j){
                i++;
            }
            if(i < j){
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        int t = arr[left];
        arr[left] = arr[i];
        arr[i] = t;
        quickSort(arr,left,i-1);
        quickSort(arr,i+1,right);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    class ListNode{
        int val;
        ListNode next;
        ListNode prev;

    }

    public static void findMaxNum2(int[] arr,int num){
       // ListNode head = new ListNode(arr[0]);
        //  5 -> 4-> 2
    }



}
