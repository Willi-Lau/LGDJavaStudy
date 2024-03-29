package com.lwy2.didi;

public class LinkedNodeAdd {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }

        ListNode node = null;

        if (l1 != null && l2 != null){
            if(l1.val < l2.val){
                node = l1;
                node.next = mergeTwoLists(l1.next,l2);
                return node;
            }
            else {
                node = l2;
                node.next = mergeTwoLists(l1,l2.next);
                return node;
            }
        }
        
        return node;
    }
}
