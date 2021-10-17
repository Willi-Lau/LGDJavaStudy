package com.lwy2.didi;
//https://leetcode-cn.com/problems/intersection-of-two-linked-lists/


/**
 * 两个长短不一的链表
 *  A   1 - 2 -3 -4 -5 -6 -7
 *  B   Q -W -E -6 -7
 *  找到从哪里开始链表相交
 *
 *  定义两个指针 一个是 A 一个是B
 *  分别从链表头开始便利 如果A走到头就从B开始走 如果B走到头就从A 开始走
 *  这样AB走的路程一样，当A=B时（相遇） 就是相交的节点了
 */
public class Lianbiaoxiangjiao {
    public static void main(String[] args) {

    }



    class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
    }
     public ListNode find(ListNode nodeA,ListNode nodeB){
        ListNode headB = nodeB;
        ListNode headA = nodeA;
        if(nodeA == null || nodeB == null){
            return null;
        }

        while (nodeA != nodeB){
            nodeA = (nodeA == null?headB:nodeA.next);
            nodeB = (nodeB == null?headA:nodeB.next);
        }



        return nodeA;
     }
}
