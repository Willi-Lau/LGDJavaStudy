package com.lwy2.didi;

import java.util.HashMap;

/**
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 定义左指针右指针 无重复就移动右指针 有重复就移动左指针 存不存在可以用一个map记录
 */
public class LongString {

    public static void main(String[] args) {
        int abcaab = lengthOfLongestSubstring("abcdaabrrrrdfghjk");
        System.out.println(abcaab);
    }

    public static int lengthOfLongestSubstring(String s) {

        char[] chars = s.toCharArray();
        int max = 1;

        for(int i=0;i<chars.length;i++){
            HashMap map = new HashMap();
            map.put(chars[i],i);
            int m = i+1;
            int sum = 1;
            while(m<chars.length &&(!map.containsKey(chars[m]))){
                    sum ++;
                    map.put(chars[m],m);
                    m++;
            }
            if(sum > max){
                max = sum;
            }
        }
        return max;
    }
}
