package com.lwy.Leetcode.Offer;

/**
 * 剑指 Offer 22. 链表中倒数第k个节点
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 *
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 *
 *
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 *
 * 返回链表 4->5.
 */
public class Offer22_20210222 {
}

/**
 * 思路：使用快慢指针 快指针比慢指针先行走k步，这样快指针到终点时慢指针就到了索要找的位置上
 * 判断指针是否到头 ListNode = null 就是到头了
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution_offer22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        //设置快慢指针
        ListNode quick = head;
        ListNode slow = head;
        //快指针位置
        while (quick != null && k >0){
            quick = quick.next;
            k--;
        }
        //快慢指针并发
        while (quick != null){
            quick = quick.next;
            slow = slow.next;
        }
        //返回慢指针
        return slow;
    }
}