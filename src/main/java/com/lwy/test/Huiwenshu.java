package com.lwy.test;

/**
 * 输入任意长度字符串，找到里面最长的回文数长度返回。
 * eg:   aaaaaabc
 * return: 6
 */
public class Huiwenshu {

    public static void main(String[] args) {
        Huiwenshu huiwenshu = new Huiwenshu();
        String s = "aaabcbabbbbbcbbbbb";
        int i = huiwenshu.LongestStr(s);
        System.out.println(i);

    }



    //循环
    public int LongestStr(String str){
        int flag=0;
        //循环所有可能
       for (int i = 0;i <= str.length();i++){
           for (int j = i+1;j <= str.length();j++){
               String s = str.substring(i,j);
               int max = isHWS(s);
               if (max > flag){
                   flag = max;
               }
               System.out.println(s+" "+isHWS(s));
           }
       }


        return flag;
    }

    //判断是否是回文数
    public int isHWS(String s){
        int max = 0;
        if(s.length() == 1){
            max = 1;
        }
        if ( s.length() %2 == 0){  //偶数
            int flag = s.length();
            String string = new StringBuffer(s.substring(flag / 2, flag)).reverse().toString();
            if(s.substring(0,flag/2).equals(string)){
                max = flag;
            }
        }
        if ( s.length() %2 != 0 && s.length() != 1){  //奇数
            int flag = s.length();
            String string = new StringBuffer(s.substring((flag+1)/2,flag)).reverse().toString();
            if(s.substring(0,(flag-1)/2).equals(string)){
                max = flag;
            }

        }

        return max;

    }

}



