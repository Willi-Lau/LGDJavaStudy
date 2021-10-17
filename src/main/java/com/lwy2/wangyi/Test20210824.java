package com.lwy2.wangyi;

import com.lwy2.entity.ListNode;

public class Test20210824 {

    public static void main(String[] args) {

        ListNode node3 = new ListNode(9);

        ListNode node4 = new ListNode(9);
        ListNode node5 = new ListNode(9,node4);
        ListNode node6 = new ListNode(9,node5);
        ListNode node7 = new ListNode(9,node6);
        ListNode node8 = new ListNode(9,node7);
        ListNode node9 = new ListNode(9,node8);
        ListNode node16 = new ListNode(9,node9);
        ListNode node26 = new ListNode(9,node16);
        ListNode node36 = new ListNode(9,node26);
        ListNode node46 = new ListNode(1,node36);

        ListNode rt = new Test20210824().addTwoNumbers(node3,node46);
//        while (rt != null){
//            System.out.println(rt.val);
//            rt = rt.next;
//        }

        int x = 2;
        double pow = Math.pow(10, 2);
        int q = (int) pow;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int num1 = 0;
        int num2 = 0;
        int n1 = 0;
        int n2 = 0;
        while(l1 != null && l2 != null){
            num1 = (int)Math.pow(10,n1) * l1.val + num1;
            num2 = (int)Math.pow(10,n2) * l2.val + num2;
            n1++;
            n2++;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null){
            num1 = (int)Math.pow(10,n1) * l1.val + num1;
            n1++;
            l1 = l1.next;
        }
        while(l2 != null){
            num2 = (int)Math.pow(10,n2) * l2.val + num2;
            System.out.println(num2);
            n2++;
            l2 = l2.next;
        }

        int sum = num1 + num2;
        //System.out.println(sum);
        ListNode head = new ListNode(0);
        ListNode node = head;
        if(sum == 0){
            return head;
        }
        while(sum != 0){
            int x = sum % 10;
            node.next = new ListNode(x);
            node = node.next;
            sum = sum / 10;
        }

        return head.next;
    }
}
