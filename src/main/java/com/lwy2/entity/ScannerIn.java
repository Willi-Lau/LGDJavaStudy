package com.lwy2.entity;

import java.util.Scanner;

public class ScannerIn {


    /**
     *    输入：
     *          3
     *          1 2 3  -》 存数组
     *          5
     *          1 2 3 4 5
     *              */
    {
        Scanner sc =new Scanner(System.in);

        while(sc.hasNext()){
            int n = sc.nextInt();
            int[] arr =new int[n];
            for(int i=0;i<n;i++){
                arr[i] = sc.nextInt();
            }
            System.out.println("**********");
            for (int i:arr){
                System.out.print(i+" ");
            }

        };

        sc.close();
    }
    /**
     * 3  -> 三组数
     *  5  -》 第一组大小
     *   1 2 3 4 5
     *  4  -》 第二组大小
     *    1 2 3 4
     *  3  -》 第三组大小
     *    1 2 3
     */
    {
        Scanner sc =new Scanner(System.in);

        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            int m = sc.nextInt();
            int[] arr = new int[m];
            for(int j=0;j<m;j++){
                arr[j] = sc.nextInt();
            }

            System.out.println("*********");
            System.out.println(m + " m");
            for (int s:arr){
                System.out.print(s);
            }
        }
        sc.close();
    }
}
