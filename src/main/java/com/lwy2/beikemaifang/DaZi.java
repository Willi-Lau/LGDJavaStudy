package com.lwy2.beikemaifang;

import java.util.Scanner;
import java.util.concurrent.CountDownLatch;


/**
 小明同学刚刚学习打字，现在老师叫他输入一个英文字符串。小明发现，这个英文字符串只由大写和小写的英文字母构成。小明同学只会使用Caps Lock键来切换大小写输入。最开始，大写锁定处于关闭状态，小明的电脑只能输入小写英文字母。当大写锁定关闭时，按一下Caps Lock键可以打开大写锁定，之后只能输入大写字母；当大写锁定打开时，按一下Caps Lock键可以关闭大写锁定，之后只能输入小写字母。现在小明想知道输入这个字符串最少需要按键多少次。
 输入描述：
 输入只有一行，一个字符串，字符串中只有大写字母和小写字母，字符串长度不超过100000。
 输出描述：
 输出一行，最少的按键次数。
 输入样例：
 aAAbB
 输出描述：
 8
 样例解释：按键方式为：a+Caps Lock+A+A+Caps Lock+b+Caps Lock+B。
 */
public class DaZi {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        System.out.println(test(s));
    }

    public static int test(String s){
        int sum = s.length();
        int flag = 0;
        char[] chars = s.toCharArray();
        for(int i=0;i<s.length();i++){
            char c = chars[i];
            int u;
            if(c >= 'a' && c <='z'){
                u = -1;
            }
            else {
                u = 1;
            }

            if(u==flag || flag == 0){
                flag = u;
                continue;
            }
            else {
                sum ++;
                flag = -flag;
            }
        }

        return sum;
    }
}
