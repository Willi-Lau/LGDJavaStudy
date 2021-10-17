package com.lwy2.beikemaifang;

/**
 问题 1、
 问题描述：
 小 A 设计了一种新的加密技术，可以采用一种聪明的办法在一个字符串中的字符之间插入随机字符串，从
 而对信息进行编码。出于保密考虑，关于如何在原有信息中产生和插入字符串的方式不会详细阐述。但为
 了验证方法的有效性，需要编写一个程序来验证原来的信息是否全在编码后的字符串中。给定两个字符串
 s 和 t，需要判断 s 是否是 t 的“子序列”。即如果去掉 t 中的某些字符，剩下字符可以连接构成字符串 s。
 输入描述：
 输入中包括多组测试样例（不超过 1000 组）。每组测试样例是由空格分隔的两个字符串构成，每个字符串
 由 ASCII 码字母或数字组成，长度不超过 100000。
 输出描述：
 对每个测试样例单独输出一行，若 s 为 t 的“子序列”，则输出"Yes"，否则输出"No"。
 输入样例：
 sequence subsequence
 person compression
 VERDI vivaVittorioEmanueleReDiItalia
 caseDoesMatter CaseDoesMatter
 输出样例：
 Yes
 No
 Yes
 No
 */
public class PanDuanShiFouZiXuLie {

    public static void main(String[] args) {
        boolean test = test("person", "compression");
        System.out.println(test);
    }

    public static boolean test(String son,String father){
        char[] father_arr = father.toCharArray();
        char[] son_arr = son.toCharArray();


        for(int i=0;i<father.length();i++){
            int len = son.length();
            if(father_arr[i] == son_arr[0]){
                int k = 0;
                for(int j=i;j<father.length();j++){
                    if(son_arr[k] == father_arr[j]){
                        k++;
                        len--;
                    }

                    if(len == 0){
                        return true;
                    }
                }


            }

        }

        return false;

    }


}
