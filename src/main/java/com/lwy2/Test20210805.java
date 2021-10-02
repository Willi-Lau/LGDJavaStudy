package com.lwy2;

import com.lwy2.entity.ListNode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Test20210805 {
    public static void main(String[] args) {
        ConcurrentHashMap map = new ConcurrentHashMap();
        ListNode node1 = new ListNode(6);
        ListNode node2 = new ListNode(1,node1);
        ListNode node3 = new ListNode(9);

        ListNode node4 = new ListNode(9);
        ListNode node5 = new ListNode(9,node4);
        ListNode node6 = new ListNode(9,node5);
        ListNode node7 = new ListNode(9,node6);
        ListNode node8 = new ListNode(9,node7);
        ListNode node9 = new ListNode(9,node8);
        ListNode node15 = new ListNode(9,node9);
        ListNode node25 = new ListNode(9,node15);
        ListNode node35 = new ListNode(9,node25);
        ListNode node46 = new ListNode(1,node35);
        ListNode listNode = addTwoNumbers(node3,node46);

        while(listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }

    public static String minWindow(String s, String t) {
        if(s.equals(t)){
            return s;
        }
        if(t.length() > s.length()){
            return "";
        }
        char[] arr = s.toCharArray();
        char[] arr1 = t.toCharArray();
        HashMap<Character,Integer> map = new HashMap();
        int min = s.length();
        String sb = s;
        for(char c:arr1){
            map.put(c,0);
        }
        for(int i=0;i<s.length();i++){
            int j = i;
            while(!isAll(map) && j < s.length()){
                if(map.containsKey(arr[j])){
                    map.put(arr[j],1);
                }
                j++;
            }
            if(j - i + 1< min && isAll(map)){
                sb = s.substring(i,j);
                min = Math.min(j - i + 1,min);
                System.out.println(sb);
            }
            for(char c:arr1){
                map.put(c,0);
            }
        }
        return sb;
    }

    public static boolean isAll(HashMap<Character,Integer> map){
        AtomicInteger k = new AtomicInteger(0);
        map.forEach((a,b)->{
            if(b.equals(0)){
                k.set(1);
            }
        });
        if(k.get() == 1){
            return false;
        }
        else{
            return true;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int m1 = 0;
        int m2 = 0;
        int flag = 0;

        while(l1!= null && l2 != null){
            m1 = m1 + l1.val * (int)Math.round(Math.pow(10,flag));
            m2 = m2 + l2.val * (int)Math.round(Math.pow(10,flag));
            l1 = l1.next;
            l2 = l2.next;
            flag ++;
        }

        while(l1 != null){
            m1 = m1 + l1.val * (int)Math.round(Math.pow(10,flag));
            l1 = l1.next;
            flag ++;
        }

        while(l2 != null){
            m2 = m2 + l2.val * (int)Math.round(Math.pow(10,flag));
            l2 = l2.next;
            flag ++;
        }
        int sum = m1 + m2;
        System.out.println(sum);
        ListNode head =new ListNode(0);
        ListNode re  = head;
        while(sum/10 != 0){

            head.next = new ListNode(sum %10);
            sum = sum/10;
            head = head.next;
        }
        head.next = new ListNode(sum);

        return re.next;
    }

    // hash 长度  0 1


}




