package com.lwy.Leetcode.Offer;

/**
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 *
 * 返回删除后的链表的头节点。
 *
 * 注意：此题对比原题有改动
 *
 * 示例 1:
 *
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * 示例 2:
 *
 * 输入: head = [4,5,1,9], val = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 *  
 *
 * 说明：
 *
 * 题目保证链表中节点的值互不相同
 * 若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class ListNode_Offer18 {
    int val;
    ListNode_Offer18 next;
    ListNode_Offer18(int x) { val = x; }
 }

public class Offer18_20200218 {

    public static void main(String[] args) {

    }

}


class Solution_Offer18 {
    public ListNode deleteNode(ListNode head, int val) {
        //空判断
        if(head == null){
            return head;
        }
        //删除的是头节点
        if(head.val == val)
            return head.next;
        ListNode flag = head;
        //找到要删除的节点的上一个，把他下一个节点替换成下下个
        //注意不要用head循环 会报错 用一个自定义的falg接收一下在循环
        while(flag.next != null && flag.next.val != val){


            flag = flag.next;



        }
        flag.next = flag.next.next;





        return head;
    }
}