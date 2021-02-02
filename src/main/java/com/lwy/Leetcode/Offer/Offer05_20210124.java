package com.lwy.Leetcode.Offer;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer05_20210124 {
}

/**
 * 思路 新建一个StringBuffer 循环原来的String s 如果不是空格就正常追加，是空格就追截 %20
 */
class Solution_offer05 {
    public String replaceSpace(String s) {
        StringBuffer stringBuffer = new StringBuffer();
        for (char c:s.toCharArray()){
                if(c == ' ') stringBuffer.append("%20");
                else stringBuffer.append(c);
            }

        return stringBuffer.toString();
    }
}