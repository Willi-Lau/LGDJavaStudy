package com.lwy2.wangyi;


import javafx.util.converter.LongStringConverter;

import java.util.*;

public class Test0816 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        String s = sc.nextLine();
//        String b = sc.nextLine();
//        String[] s1 = s.split(" ");
//
//        int[] arr = new int[s1.length];
//        for (int i=0;i<s1.length;i++){
//            arr[i] = Integer.parseInt(s1[i]);
//        }
//
//        int flag = 0;
//        int num = Integer.parseInt(b);
//        for(int i=0;i<arr.length;i++){
//            for(int j=i+1;j<arr.length;j++){
//                    if((arr[j] + arr[i]) <= num){
//                        flag ++;
//                    }
//                }
//        }
//
//        System.out.println(flag);
//    }
//    public static void main(String[] args) {
//        Test0816 test0816 = new Test0816();
//        char k = test0816.findKthBit(4,11);
//        System.out.println(k);
//
//    }
//    List<String> list;
//    HashMap<String,String> map;
//    public char findKthBit(int x,int y){
//        list = new ArrayList<>();
//        Collections.addAll(list,"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z");
//        map = new HashMap<>();
//
//        for (int i=0;i<list.size();i++){
//            map.put(list.get(i),list.get(26-i-1));
//        }
//
//        String[] arr = new String[26];
//        arr[0] = "a";
//
//        for (int i=1;i<x;i++){
//            arr[i] = arr[i-1] + list.get(i) + reserve(invert(arr[i-1]));
//
//        }
//
//
//
//        return arr[x-1].charAt(y-1);
//    }
//
//    public String invert(String s){
//        String k = "";
//        char[] chars = s.toCharArray();
//        for (char c : chars){
//            String s1 = String.valueOf(c);
//            String s2 = map.get(s1);
//            k = k + s2;
//        }
//
//        return k;
//    }
//
//    public String reserve(String s){
//
//        char[] chars = s.toCharArray();
//        List<Character> list = new ArrayList();
//        for (char c:chars){
//            list.add(c);
//        }
//        Collections.reverse(list);
//        String k = "";
//        for (char c:list){
//            k = k + c;
//        }
//
//        return k;
//    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String s = sc.nextLine();
//        String[] s1 = s.split(" ");
//        int[] arr = new int[s1.length];
//
//        for (int i=0;i<s1.length;i++){
//            arr[i] = Integer.parseInt(s1[i]);
//        }
//
//        int sum = 0;
//        int min = arr[0];
//        int min_num = 0;
//        //先找到最小的开始
//        for (int i=0;i<arr.length;i++){
//            if(arr[i] < min){
//                min_num = i;
//            }
//        }
//
//        int[] num = new int[arr.length]; //记录数字
//        num[min_num] = 1;
//
//        if(min_num == 0) {
//            for (int i = 1; i < arr.length; i++) {
//                if (arr[i] > arr[i - 1]) {
//                    num[i] = num[i - 1] + 1;
//                } else if (arr[i] == arr[i - 1]) {
//                    num[i] = num[i - 1];
//                } else {
//                    num[i] = num[i - 1] - 1;
//                }
//            }
//        }
//        else if(min_num == arr.length-1){
//            for (int i=arr.length-1;i>0;i--){
//                if(arr[i]>arr[i+1]){
//                    num[i] = num[i+1]+1;
//                }
//                else if(arr[i] == arr[i+1]){
//                    num[i] = num[i+1];
//                }
//                else {
//                    num[i] = num[i+1] -1;
//                }
//            }
//        }
//        else {
//            for (int i = 1; i < min_num; i++) {
//                if (arr[i] > arr[i - 1]) {
//                    num[i] = num[i - 1] + 1;
//                } else if (arr[i] == arr[i - 1]) {
//                    num[i] = num[i - 1];
//                } else {
//                    num[i] = num[i - 1] - 1;
//                }
//            }
//            for (int i = min_num; i < arr.length; i++) {
//                if (arr[i] > arr[i - 1]) {
//                    num[i] = num[i - 1] + 1;
//                } else if (arr[i] == arr[i - 1]) {
//                    num[i] = num[i - 1];
//                } else {
//                    num[i] = num[i - 1] - 1;
//                }
//            }
//        }
//
//        for (int i:num){
//            sum += i;
//        }
//
//        System.out.println(sum);
//
//
//    }
    public static void main(String[] args) {
        Test0816 t = new Test0816();
        int[][] arr = new int[][]{{1,1,1,1,0},{0,1,0,1,0},{1,1,2,1,1},{0,2,0,0,1}};
        System.out.println(t.minSailCost(arr));
    }
    List<Integer> list;
    public int minSailCost (int[][] input) {
        // write code here
        int x = input.length;
        int y = input[0].length;

        int m = 0;
        int n = 0;

        list = new ArrayList<>();
        int[][] op = new int[x][y];
        test(input,m,n,x,y,0,op,0);
        int min = list.get(0);
        for (int i:list){
            System.out.println(i);
            min = Math.min(min,i);
        }
        
        return min;
    }

    public void test(int[][] input,int m,int n,int x,int y,int sum,int[][] op,int all){
        if(n >= y || m >= x || (m == x-1 && n == y -1) || all > x*y){
            list.add(sum);
            return;
        }
        int[][] kkk = {{0,1},{1,0}};
        int n1 = n;
        int m1 = m;
        for(int i=0;i<2;i++){
            m = m + kkk[i][0];
            n = n + kkk[i][1];
            if(m >= x || n >= y){
                return;
            }
            if(input[m][n] == 0){
                sum += 2;
                op[m][n] =1;
                test(input,m,n,x,y,sum,op,all+1);
            }
            if(input[m][n] == 1){
                sum += 1;
                op[m][n] =1;
                test(input,m,n,x,y,sum,op,all+1);
            }
            if(m == m1 && n == n1){
                return;
            }

        }

        return;
    }

}
