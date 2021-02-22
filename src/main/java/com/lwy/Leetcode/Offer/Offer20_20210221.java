package com.lwy.Leetcode.Offer;

import java.util.ArrayList;
import java.util.List;

public class Offer20_20210221 {
}


/**
 ‘.’出现正确情况：只出现一次，且在e的前面

 ‘e’出现正确情况：只出现一次，且出现前有数字

 ‘+’‘-’出现正确情况：只能在开头和e后一位
 **/

class Solution_offer20 {
    public boolean isNumber(String s) {
        String trim = s.trim();
        char[] chars = trim.toCharArray();
        if(chars.length == 0){
            return false;
        }
        //计数
        List<Integer> listpoint = new ArrayList();
        List<Integer>  liste = new ArrayList();
        List<Integer>  listaddcut = new ArrayList();

        for (int i=0;i<chars.length;i++){
            if(chars[i] == '.'){
                listpoint.add(i);
            }
            if(chars[i] == 'e' || chars[i] == 'E'){
                liste.add(i);
            }
            if(chars[i] == '-' || chars[i] == '+'){
                listaddcut.add(i);
            }
            //执行一次判断一次
            if(listpoint.size() == 2) return false;
            if(liste.size() == 2) return false;


        }
        //执行后总判断
        if(listpoint!= null &&listpoint.size() !=0){
            //. zai 1
            if(listpoint.get(0) == 0 &&listpoint.size() == 1){
                if(chars.length <2){
                    return false;
                }
                else {

                }

            }
            else {
                if(listpoint.size() == 1){
                    if(!(listpoint.get(0) == liste.get(0)-1&&chars.length>=2)){
                        return false;
                    }
                }
                else {return false;}
            }



        }
        if(liste!= null&&liste.size() !=0){
            if(liste.get(0) !=0){
                char num = chars[liste.get(0) - 1];
                if(!(num == '0' || num == '1' || num == '2' || num == '3' || num == '4' || num == '5'
                        ||num == '6' || num == '7' || num == '8' || num == '9'))
                {
                    return false;
                }
            }
            else {
                return false;
            }

        }
        if(listaddcut!= null&&listaddcut.size() !=0){
            if(liste!= null&&liste.size() !=0){
                if (!(listaddcut.size() == 2 &&
                        (
                                (listaddcut.get(0) == 0 && listaddcut.get(1) == liste.get(0)+1)
                                        || (listaddcut.get(1) == 0 && listaddcut.get(0) == liste.get(0)+1)
                        )
                )){
                    return false;
                }
            }
            else {
                if(!(listaddcut.size()==1 && listaddcut.get(0) == 0)){
                    return false;
                }
            }

        }





        return true;
    }
}