package com.lwy.Leetcode.Offer;


import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 剑指 Offer 17. 打印从1到最大的n位数
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 *
 * 示例 1:
 *
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 */
public class Offer17_20210208 {
    public static void main(String[] args) {
        Solution_offer17 offer17 = new Solution_offer17();
        offer17.printNumbers(3);


    }


}

/**
 * 思路：从小到大依次打印，i=1 到 N 再进行除左0 操作
 */
class Solution_offer17 {
    int n;
    List<String> list;
    String[] c;
    List<String> nextlist;
    public static String startwithZero(String s){
        if (s.startsWith("0")){
            int length = s.length();
            return startwithZero(s.substring(1,length));
        }
        else {
            return s;
        }



    }
    public void   printNumbers(int n) {
        this.n = n;
        this.c = new String[]{"0","1","2","3","4","5","6","7","8","9"};

        this.list = new ArrayList();
        this.nextlist = new ArrayList();


        Collections.addAll(list,"0","1","2","3","4","5","6","7","8","9");
        bignum(4);



    }
//首先添加个位 再循环递归 添加十位  再百位
    public void bignum(int n){
      if ( n>0){
          list.forEach((i)->{
              StringBuffer f = new StringBuffer( i);
              for (int j=0;j<=9;j++){
                  StringBuffer x = new StringBuffer(c[j]);
                  StringBuffer s = x.append(f);
                  String s1 = s.toString();
                  String s2 = startwithZero(s1);
                  nextlist.add(s2);
              }
          });
          list.clear();
          this.nextlist.forEach((i)->{
              this.list.add(i);
          });
          nextlist.clear();
          bignum(--n);


      }
      else {


          Set set  = new HashSet();
          CopyOnWriteArrayList slist = new CopyOnWriteArrayList();
          list.forEach((i)->{
              if(i!= ""&& i.length() != 0)
              slist.add(Integer.parseInt(i));
          });
          Collections.sort(slist);
          slist.forEach((i)->{
              set.add(i);
          });

          set.forEach((i)->{
              System.out.println(i+" ");
          });
          return;
      }




    };

}
