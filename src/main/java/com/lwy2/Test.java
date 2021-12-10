package com.lwy2;

import com.lwy2.entity.ListNode;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Test {
    volatile static int m = 0;
    volatile static AtomicInteger atomicInteger = new AtomicInteger(0);
    static String a = "6";
    static double b = 1;
    public static void main(String[] args) throws Exception {

//        一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
//        在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
//        示例 1:
//        输入: [0,1,3]
//        输出: 2
//        示例 2:
//        输入: [0,1,2,3,4,5,6,7,9]
//        输出: 8
        int[] arr = {0,1,2,3,4,5,6,7,8,10};
        for(int i = 0 ; i < arr.length ; i++){
            if(i == 0 && arr[i] != 0){
                System.out.println(0);
                break;
            }
            else if(i > 0 && arr[i] - 1 != arr[i-1]){
                System.out.println(arr[i] - 1);
                break;
            }
        }
































    }

    public static ListNode reserve(ListNode head){
        ListNode rt = head;

        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static void sort(int[] arr){
       // quicksort(arr,0,arr.length-1);

//        int[] mergesort = mergesort(arr);
//        for (int i : mergesort){
//            System.out.println(i);;
//        }


        heapsort(arr);
    }

    public boolean sb(){
        HashMap map = new HashMap();
        AtomicBoolean t = new AtomicBoolean(true);
        map.forEach((x,m)->{
            t.set(false);
        });

        return t.get();
    }

    public static void quicksort(int[] arr,int left,int right){
        if(left > right){
            return;
        }

        int i = left;
        int j = right;
        int flag = arr[left];

        while (i != j){
            while (flag <= arr[j] && i<j){
                j--;
            }

            while (flag >= arr[i] && i<j){
                i++;
            }

            if(i<j){
                int t = arr[i];
                arr[i] =arr[j];
                arr[j] = t;
            }
        }

        int t = arr[i];
        arr[i] = arr[left];
        arr[left] = t;

        quicksort(arr,left,i-1);
        quicksort(arr,i+1,right);
    }

    public static  int[] mergesort(int[] arr){
        if(arr.length<2){
            return arr;
        }

        int[] left = Arrays.copyOfRange(arr,0,arr.length/2);
        int[] right = Arrays.copyOfRange(arr,arr.length/2,arr.length);
        return merge(mergesort(left),mergesort(right));

    }

    public static int[] merge(int[] left,int[] right){
        int[] arr = new int[left.length+right.length];
        for (int index = 0,i=0,j=0;index < arr.length;index++){
            if(i >= left.length){
                arr[index] = right[j];
                j++;
            }
            else if(j>= right.length){
                arr[index] = left[i];
                i++;
            }

            else if(left[i] > right[j]){
                arr[index] = right[j];
                j++;
            }
            else {
                arr[index] = left[i];
                i++;
            }
        }

        return arr;
    }

    static int len;
    public static void heapsort(int[] arr){
         len = arr.length;
        if(len <1){
            return;
        }
        buildheap(arr);
        while (len >0){
            swap(arr,0,len-1);
            len --;
            changeheap(arr,0);
        }
    }

    public static void buildheap(int[] arr){
        for(int i=(len/2) -1;i>=0;i--){
            changeheap(arr,i);
        }
    }

    public static void changeheap(int[] arr,int index){
        int maxindex = index;
        //如果存在左子树 并且左子树大于根节点
        if(index *2 < len && arr[index*2] > arr[maxindex]){
            maxindex = index *2;
        }
        //如果存在右子树 并且右树大于根节点
        if(index *2 +1 <len  && arr[index*2+1]>arr[maxindex]){
            maxindex = index *2 +1;
        }

        //交换
        if(maxindex != index){
            swap(arr,maxindex,index);
            changeheap(arr,maxindex);
        }
    }

    public static void swap(int[] arr,int x,int y){
        int t = arr[x];
        arr[x] = arr[y];
        arr[y] = t; 
    }
}

