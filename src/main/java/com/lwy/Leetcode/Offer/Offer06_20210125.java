package com.lwy.Leetcode.Offer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *  
 *
 * 限制：
 *
 * 0 <= 链表长度 <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer06_20210125 {
}
//这是自定义的一个链表
class ListNode {
      //数据的值
      int val;
      //指针 指向下一个数据
      ListNode next;
      ListNode(int x) { val = x; }
}

/**
 * 思路 反向输出 就利用Stack 的FILO特性即可
 */
class Solution_offer06 {
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head!= null) {
            stack.push(head.val);
            //指向下一个
            head = head.next;
        }
        int l = stack.size();
       int[] arr =new int[l];
       for (int i=0;i<l;i++){
           arr[i] = stack.pop();
       }

       return arr;
    }
}