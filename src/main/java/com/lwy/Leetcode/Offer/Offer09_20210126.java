package com.lwy.Leetcode.Offer;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 *  
 *
 * 示例 1：
 *
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * 示例 2：
 *
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.Deque;
import java.util.LinkedList;

/**
 * 题目说明
 * 简单明了，带你直接看懂题目和例子。 输入： ["CQueue","appendTail","deleteHead","deleteHead"] 这里是要执行的方法，从左到右执行
 *
 * [[],[3],[],[]]对应上面的方法，是上面方法的参数。CQueue和deleteHead方法不需要指定数字，只有添加才需要指定数字
 *
 * 1.创建队列，返回值为null
 *
 * 2.将3压入栈，返回值为null
 *
 * 3.将栈底的元素删除，也就是消息队列中先进来的元素，所以是deleteHead，返回该元素的数值，所以为3
 *
 * 4.继续删除栈底的元素，但是没有元素了，所以返回-1
 *
 * 所以就有了下面的输出 输出：[null,null,3,-1]
 *
 * 示例 2： 输入： ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 *
 * [[],[],[5],[2],[],[]]
 *
 * 1.创建队列，返回值为null
 *
 * 2.删除栈底的元素，但是没有元素，所以返回-1
 *
 * 3.把5压入栈，返回null
 *
 * 4.把2压入栈，返回null
 *
 * 5.删除栈底的一个元素，也就是消息队列中先进来的元素，所以是deleteHead，就是最先进来的5，返回值为5，
 *
 * 6.删除栈底的一个元素，就是后进来的2，返回值为2，
 *
 * 所以就有了下面的输出
 *
 * 输出：[null,-1,null,null,5,2]
 *
 * 有没有发现先进来的数字，首先显示出来了，但是题目中说要使用栈，栈是先进后出的，使用栈来实现先进先出，在这里使用两个栈就好了，从一个进来再到另一个栈，这样顺序就是先进先出了。题目的主旨写在第一句，就是，使用两个栈实现一个队列
 */
public class Offer09_20210126 {
}

/**
 * 一个Stack 控制添加   一个Stack控制删除 执行删除时把添加的Stack的值通过pop()取出来 添加到删除Stack 再从删除的Stack()删除元素，执行pop()操作
 */
class CQueue {

    //Stack FILO
    //Deque 是双向队列 既可以FIFO (Queue) 也可以FILO(Stack) 他的实现类有LinkedList 这里就用LinkedList

    Deque<Integer> stack1;
    Deque<Integer> stack2;

    public CQueue() {
        //新创建两个 Stack
        stack1 = new LinkedList();
        stack2 = new LinkedList();
    }

    public void appendTail(int value) {
        //添加只需要添加到一个就好了
        stack1.addFirst(value);
    }

    public int deleteHead() {
        //首先如果stack2为空 把stack1的值添加到stack2中 FILO
        //stack2 2只存入要删除的元素 别的都不要 所以要判断是不是空
        if(stack2.isEmpty() == true){
        while (stack1.isEmpty() == false){
             stack2.addFirst(stack1.removeFirst());
        }}
        //再判断Stack2是不是空，是空返回 -1 不是返回对应值
        if(stack2.isEmpty() == true){
            return -1;
        }
        else {
            return stack2.removeFirst();
        }

    }
}
