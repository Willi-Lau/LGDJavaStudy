package com.lwy2.entity;

import java.util.Arrays;
import java.util.HashMap;

public class Father {
    public static void main(String[] args) {
        System.out.println(isHappy(7));
        int i = Integer.MAX_VALUE;
    }

    public static boolean isHappy(int n) {
        HashMap<Integer,Integer> map = new HashMap();
        return happy(n,map);
    }

    public static boolean happy(int n,HashMap<Integer,Integer> map){
        int sum = 0;

        while(n/10 != 0){
            sum += Math.pow((n%10),2);
            n = n/10;
        }

        sum += Math.pow(n,2);
        System.out.println(sum);
        if(sum == 1){
            return true;
        }
        else if(map.containsKey(sum)){
            return false;
        }
        else{
            map.put(sum,0);
            return happy(sum,map);
        }
    }
}

class A{
    static int n;
    public A(){

    }

    static {
        System.out.println("123");
        int n = 15;
    }
    
    public void n(){

        System.out.println(n);
    }
}
