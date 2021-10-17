package com.lwy2.day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * create by: liuweiyi
 * description: TODO
 * create time: 2021/9/13 10:38
 * 
  * @Param: null
 * @return
 *
 *
 * 题目描述 ：一组数字  1 2 3 4 5 -7 -8 0 3 1 -5 。。
 *  查找尽量多的数字 满足 》=0
 *  e.g.   1 2 3 4 5  -> 5  能选择 1 2 3 4 5
 *  e.g. -1 0 1 0 -1  -> 4  能选择 -1 0 0 1
 */
public class Test20210913 {
    public static void main(String[] args) {
        int[] arr = new int[]{-1,-5,1,4,6,-8,1};
        //首先排序
        Arrays.sort(arr);
        //从后向前
        int sum = 0;
        int num = 0;
        for(int i=arr.length-1;i>0;i--){
            if(arr[i] >= 0){     //如果数大于等于0 直接加
                sum += arr[i];
                num++;
            }
            else if(arr[i] <0 && sum + arr[i] >= 0){      //数小于0 和大于等于0 可以加
                sum += arr[i];
                num++;
            }
            else{        //加上这个数 小于0 不能加了 退出
                break;
            }
        }

        System.out.println(num);
    }
}
