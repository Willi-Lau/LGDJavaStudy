package com.lwy2.didi;

public class ErFenCHaZhao {

    public static void main(String[] args) {
        int[] arr = {1,2,5,6,8,8,9};
        int a = ef(arr,0,arr.length-1,8);
        System.out.println(a);
    }

    public static int ef(int[] arr,int left,int right,int flag) {

        int mid = (left + right) / 2;
        if (left > right || flag < arr[left] || flag > arr[right])
        {
            return -1;
        }
            if(arr[mid]>flag){
                return ef(arr,left,mid-1,flag);
            }
            else if(arr[mid] <flag){
                return ef(arr,mid+1,right,flag);
            }
            else {
                return mid;
            }
    }
}
