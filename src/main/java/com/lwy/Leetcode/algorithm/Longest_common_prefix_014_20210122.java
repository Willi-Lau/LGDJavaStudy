package com.lwy.Leetcode.algorithm;


/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 *
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *  
 *
 * 提示：
 *
 * 0 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Longest_common_prefix_014_20210122 {
    public static void main(String[] args) {
        Solution14 solution14 = new Solution14();


    }
}

/**
 * 思路，找到最短的作为标准 s。循环数组按个比较，如果循环的不符合以标识s开头，就把s减1
 */
class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        String s = "";
        if(strs.length!= 0 ){
            int min = strs[0].length();
            int min_flag = 0;
            for(int i=0;i<strs.length;i++){
                if(strs[i].length() < min){
                    min = strs[i].length();
                    min_flag = i;
                }
            }
            s = strs[min_flag];

            for(String string : strs){
                while(string.startsWith(s)!= true){
                    s = s.substring(0,s.length()-1);
                    if(s.length() == 0){
                        return "";
                    }
                }

            }
        }








        return s;

    }
}