package com.lwy.Leetcode.Offer;

/**
 * 剑指 Offer 25. 合并两个排序的链表
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * 示例1：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 限制：
 *
 * 0 <= 链表长度 <= 1000
 */
public class Offer25_20210223 {
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/**
 * 思路：循环两个链表 然后新建一个新链表 找到两者里小的添加到新链表中然后继续比较
 */
class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
     //l1空了 那么新链表追加l2所有的，反之同理
       if (l1 == null ){
            return l2;
       }
       if(l2 == null){
           return l1;
       }
       //新建链表
        ListNode newListNode = null;
             //把小得加入新链表 大得留着继续比较 因为不能确定这一组大的和下一组小的谁大谁小所以每次只能添加一个进去
            if(l1.val >= l2.val){

                newListNode = l2;
                //没添加l1，所以l1不变 l2指针向后
                newListNode.next = mergeTwoLists(l1,l2.next);
            }
            else {
                newListNode = l1;
                //没添加l2，所以l2不变 l1指针向后
                newListNode.next = mergeTwoLists(l1.next,l2);

            }
            //返回
        return newListNode;
    }
}