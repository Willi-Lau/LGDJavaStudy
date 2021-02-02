package com.lwy.Leetcode.algorithm;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Valid_parentheses_020_2021_01_22 {
}

/**
 * 思路
 * 由题可知，正确的情况是左括号的顺序和右括号的顺序应该是相反的，换句话说，把所有右括号放到一起再顺序反转，对应的正好是所有左括号的循序
 * 所以这里用到了Stack Stack 是FILO
 */


class Solution20 {
    public boolean isValid(String s) {
        //创建一个Stack
        Stack<Character> stack = new Stack<>();
       if(s.length() != 0){
           char[] chars = s.toCharArray();
           //循环
           for(Character c : chars){
               //通过记录左括号的位置记录右括号的位置
               if(c.equals('(')) stack.push(')');
               else if(c.equals('{')) stack.push('}');
               else if(c.equals('[')) stack.push(']');
               //比较一个删除一个
               else if(stack.empty() || c != stack.pop()) return false;
           }
           if(stack.empty() == true){
               return true;
           }
           else {
               return false;
           }
       }
       else {
           return true;
       }




    }
}







