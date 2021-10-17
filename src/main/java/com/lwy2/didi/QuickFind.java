package com.lwy2.didi;

/**
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 *
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class QuickFind {

    public static void main(String[] args) {
        int[] arr = {5,1,2,3,4,6,8,7,7,8,8,8,8,8};
        int quickfind = quickfind(arr, 6);
        System.out.println(quickfind);
    }


    static int quickfind(int[] arr,int key){
        //具体的位置
        int index = arr.length - key;
        return quickSort(arr,0,arr.length-1,index);

    }
    static int  quickSort(int[] arr,int left,int right,int key){

        int i = left;
        int j = right;
        int flag = arr[left];
        while(i != j){
            while(arr[j]>=flag && j>i){
                j--;
            }
            while(arr[i]<=flag && j>i){
                i++;
            }
            if(i<j){
                int t = arr[i];
                arr[i] =arr[j];
                arr[j] = t;
            }
        }
        int y = arr[i];
        arr[i] =arr[left];
        arr[left] = y;

        if(key >i){
            return quickSort(arr,i+1,right,key);
        }
        else if(key == i){
            return arr[i];
        }
        else if(key < i){
           return quickSort(arr,left,i-1,key);
        }
        else {
            return -1;
        }
    }
}
