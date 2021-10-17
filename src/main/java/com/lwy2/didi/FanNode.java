package com.lwy2.didi;
/**
 * create by: liuweiyi
 * description: TODO
 * create time: 2021/7/23 9:42
 *   https://leetcode-cn.com/problems/reverse-linked-list/solution/fan-zhuan-lian-biao-by-leetcode-solution-d1k2/
  * @Param: null
 * @return
 */
public class FanNode {
    public static void main(String[] args) {
        Node node3 = new Node(3);
        Node node2 = new Node(2,node3);
        Node node1 = new Node(1,node2);
        Node fz = fz(node1);

        while(fz != null){
            System.out.println(fz.val);
            fz = fz.next;
        }


    }

    public static  Node fz(Node firstNode){
        Node prev = null;
        Node curr  =firstNode;

        while(curr != null){
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    static class Node{
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}
