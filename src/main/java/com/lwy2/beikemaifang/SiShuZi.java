package com.lwy2.beikemaifang;

import java.util.Scanner;

/**
 问题描述：
 小B正处于百无聊赖中，提不起干活的兴趣。看到桌面上的一条带着方格纸带，于是随手拿起一支笔，在纸带的每个方格中写上一个随机想起的数字。然后把纸带折起来撕成两半，她突然发现两半中各个数值加起来的和竟然是一样的。小B一下子有了一点精神，她想知道可以有多少种方式把纸带撕成两半，仍然使得两边的数值之和是相等的。你能帮她吗？
 输入描述：
 测试数据有多组，每组测试数据的第一行为一个整数n（1=< n <=100000），为纸带上的方格数，第二行为n个空格分隔的数值，为小B写入方格的数值，所有的数都是绝对值不超过10000的整数。
 输出描述：
 对每组测试数据，在单独的行中输出不同撕法的总数，使得两边纸带中的数值之和相等。将纸带撕成两半时，只能沿方格的边缘撕开。
 输入样例：
 3
 1 1 1
 9
 1 5 -6 7 9 -16 0 -2 2
 2
 0 0
 输出样例：
 0
 3
 1
 */
public class SiShuZi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] fin = new int[num];
        for (int i=0;i<num;i++){
            int len = sc.nextInt();
            int[] arr = new int[len];
            for(int j=0;j<len;j++){
                arr[j] =sc.nextInt();
            }

            fin[i] = test(len,arr);
            for(int j:fin){
                System.out.println(j);
            }
        }

        sc.close();


    }

    private static int test(int len,int[] arr) {
        int sum = 0;
        int flag = 0;
        int my_sum = 0;
        for(int i:arr){
            sum += i;
        }


        for(int i=0;i<len-1;i++){   //最后一个元素不能撕

            if(my_sum + arr[i] == sum/2){
                flag ++;
                System.out.println(arr[i]+"  "+flag);
            }

            my_sum += arr[i];

        }
        return flag;

    }
}
