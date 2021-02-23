package com.lwy.Leetcode.Offer;

/**
 * 剑指 Offer 24. 反转链表
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 *
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 5000
 *

 *                                                                                                                                                          L
 */
public class Offer24_20210223 {
}
/**
 * 思路 递归反转链表指向 就不用Stack反转因为浪费空间
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution_offer24 {
    public ListNode reverseList(ListNode head) {
            ListNode mine = null;
            ListNode next = head;
            //下一个不是空就一直向下循环
        while (next != null){
            //存储 next下一个
            ListNode flag = next.next;
            //交换指向
            next.next = mine;
            //设置下一组要交换的两个
            mine = next;
            next =flag;

        }
        return mine;
    }
}