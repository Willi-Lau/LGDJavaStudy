package com.lwy2.didi;

import javax.jws.soap.SOAPBinding;

/**
 777. 在LR字符串中交换相邻字符
 在一个由 'L' , 'R' 和 'X' 三个字符组成的字符串（例如"RXXLRXRXL"）中进行移动操作。
 一次移动操作指用一个"LX"替换一个"XL"，或者用一个"XR"替换一个"RX"。现给定起始字符串
 start和结束字符串end，请编写代码，当且仅当存在一系列移动操作使得start可以转换成end
 时， 返回True。

 https://leetcode-cn.com/problems/swap-adjacent-in-lr-string/
 */
public class LeetCode777 {
    public static void main(String[] args) {
        boolean b = Solution_777.canTransform("XLLR", "LXLX");
        System.out.println(b);
    }
}
class Solution_777 {
    public static boolean canTransform(String start, String end) {
        if(start.length() ==1 && (!start.equals(end))){
            return false;
        }
        char[] starr = start.toCharArray();
        char[] enarr = end.toCharArray();
        int i=0;
        int j=0;
        int sum1 = starr.length;
        int sum2 = sum1;
        while(i<starr.length && j<enarr.length){

            while(i+1<starr.length && starr[i] == 'X'){
                i++;
                sum1--;
            }

            while(j+1<enarr.length  && enarr[j] == 'X'){
                j++;
                sum2--;
            }
            if(starr[i]!= enarr[j] ||(starr[i] == 'L'&& i < j)||(starr[i] == 'R'&&i > j)){
                return false;
            }

            j++;
            i++;
        }

        if(i == enarr.length && j != enarr.length){
            for(int k = j;k<enarr.length;k++){
                if(enarr[k] == 'X'){
                    sum2--;
                }
            }
        }

        if(j == starr.length && i != starr.length){
            for(int k = i;k<starr.length;k++){
                if(starr[k] == 'X'){
                    sum1 --;
                }
            }
        }

        if(sum1 != sum2){
            return false;
        }
        return true;
    }
}