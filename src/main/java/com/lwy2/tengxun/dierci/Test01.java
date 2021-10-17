package com.lwy2.tengxun.dierci;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Test01 {
    public static void main(String[] args) {

         String s = "1234.456";
         Double d = new Double(0);
         boolean t = true;
         boolean point  = false;
         int flag = 1;
         for(int i=0;i<s.length();i++){

             if(!((s.charAt(i) >= '0' && s.charAt(i) <= '9' )||(s.charAt(i) == '.'))){
                 t = false;
                 break;
             }
             else{
                 if(s.charAt(i) == '.'){
                     point = true;
                     continue;
                 }
                 if(!point){   //小数点之前
                     d = d * 10 + new Test01().find(s.charAt(i));
                 }
                 else{   //小数点之后
                     d += new Test01().find(s.charAt(i)) / Math.pow(10,flag);
                     flag ++;
                 }
             }
         }

         if(t)
              System.out.println(Math.round(d * Math.pow(10,flag)) / Math.pow(10,flag));
         else
             System.out.println("false");


    }

    public double find(char i)
    {
        if(i == '0'){
            return 0;
        }
        else if(i == '1'){
            return 1;
        }
        else if(i == '2'){
            return 2;
        }
        else if(i == '3'){
            return 3;
        }
        else if(i == '4'){
            return 4;
        }
        else if(i == '5'){
            return 5;
        }
        else if(i == '6'){
            return 6;
        }
        else if(i == '7'){
            return 7;
        }
        else if(i == '8'){
            return 8;
        }
        else{
            return 9;
        }


    }



    public static int find(int a,int b){
        int c;
        do{
            c = a ^ b;
            b = a & b << 1;
            a = c;
        }
        while(b !=0);
        return c;
    }

    public String  find(String x){
        String s = x;
        char[] chars = s.toCharArray();
        String b = "";
        for (int i=0;i<chars.length;i++){
            if(!(chars[i] == '1' || chars[i] == '2' || chars[i] == '3')&& chars[i]!= '0'){
                chars[i] = '3';
            }
            else {

            }
            b = b + chars[i];
        }

        //int sb = Integer.parseInt(b);


//        if(sb > x){
//            sb = sb - (int) Math.pow(10,b.length()-1);
//        }
        return b;

    }


}
