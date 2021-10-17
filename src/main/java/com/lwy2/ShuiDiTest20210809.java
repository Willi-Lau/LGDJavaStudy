package com.lwy2;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

/**
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 */
public class ShuiDiTest20210809 {

    public static void main(String[] args) throws InterruptedException {




    }

    public void minWindow(String s, String t) {
        int left = 0;
        int right = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        for (char i:t.toCharArray()){
            set.add(i);
        }
        int lenS = s.length();
        int lenT = t.length();
        HashMap<Integer,Integer> map1 = new HashMap<>();
        while(true){
            if(left >= lenS || right >= lenS){
                break;
            }
            while(right < lenS && left <= right){
                if( (set.contains(s.charAt(right)) && !map.containsKey(s.charAt(right)))  ){
                    map.put(s.charAt(right),right);
                    if(map.size() == set.size()){
                        int min = Integer.MAX_VALUE;
                        int max = 0;
                        for(char c: set){
                            int i = map.get(c);
                            if(i <= min){
                                min = i;
                            }
                            if(i >= max){
                                max = i;
                            }
                        }
                        map1.put(min,max);

                    }
                    right++;
                }
                else if(!set.contains(s.charAt(right))){
                    right++;
                }
                else if(set.contains(s.charAt(right)) && map.containsKey(s.charAt(right))){
                    int index = map.get(s.charAt(right));
                    int min1 = Integer.MAX_VALUE;

                    for(char c: set){
                        int i = map.get(c);
                        if(i <= index){
                            map.remove(c);
                        }
                        if(i < min1 && min1 > index){
                            min1 = i;
                        }

                    }
                    left = min1;
                    map.put(s.charAt(right),right);
                    if(map.size() == set.size()){
                        int min = Integer.MAX_VALUE;
                        int max = 0;
                        for(char c: set){
                            int i = map.get(c);
                            if(i <= min){
                                min = i;
                            }
                            if(i >= max){
                                max = i;
                            }
                        }
                        map1.put(min,max);

                    }
                    right ++;
                }
            }

        }
        AtomicInteger min = new AtomicInteger();
        min.set(Integer.MAX_VALUE);
        map1.forEach((x,y)->{
            min.set(Math.min(min.get(), y - x));
        });

        //return min;
    }


}
