package com.lwy2.beikemaifang;

import java.util.Scanner;

/**
 题4、
 问题描述：
 人民币有很多不同面值的纸币，在本题中，只考虑以下7种面值的纸币，它们分别为：1元、2元、5元、10元、20元、50元、100元。你知道凑出n元最少需要多少张纸币吗？
 输入描述:
 第一行输入一个数T（1<=T<=10000），表示数据组数。接下来有T行，每行一个数n（1<=n<=100000）。输出描述：
 每组数据输出一行，最少需要的纸币数。
 输入样例：
 5
 3
 4
 5
 9
 99
 输出样例：
 2
 2
 1
 3
 6
 样例解释：
 样例中第一行为5，表示一共有5组数据。
 第一组数据为3，答案为：1张1元+1张2元，一共2张纸币。
 第二组数据为4，答案为：2张2元，一共2张纸币。
 第三组数据为5，答案为：1张5元，一共1张纸币。
 第四组数据为9，答案为：2张2元+1张5元，一共3张纸币。
 第五组数据为99，答案为：2张2元+1张5元+2张20元+1张50元，一共6张纸币。
 */
public class CouQian {
    static int sum = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        test(i);
        System.out.println(sum);
    }

    public static void test(int num){
        if(num == 0){
            return;
        }

        if(num >=100){
            sum ++;
            test(num-100);
        }
        else if(num >= 50){
            sum++;
            test(num - 50);
        }
        else if(num >= 20){
            sum++;
            test(num - 20);
        }
        else if(num >= 10){
            sum++;
            test(num - 10);
        }
        else if(num >= 5){
            sum++;
            test(num - 5);
        }
        else if(num >= 2){
            sum++;
            test(num - 2);
        }
        else if(num >= 1){
            sum++;
            test(num - 1);
        }
    }
}
