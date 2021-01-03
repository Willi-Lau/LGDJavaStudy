package com.lwy.Leetcode.algorithm;

import java.util.EventListener;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 你可以按任意顺序返回答案。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2：
 *
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 示例 3：
 *
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoSum_01_20210103 {


}

/**
 * 通过HashMap 实现的原理  存的值 key: mun[i]   value: i
 * 循环原数组，然后HashMap刚开始是空的，通过target - num[i] 比较 hashmap 里面的的值
 * 如果匹配，输出 i 和 hashmap 里存的数的 i
 * 如果不匹配，就把这和数和他的 下标存到 HashMap中，让下一个数 和target 的差值继续和原数组比较，总会有一样的
 * 这样循环一次，就算循环到最后也可以找到所匹配的值
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {

        //首先求出每一个target 和num 的差值，再用差值和数组比对
        ConcurrentHashMap<Integer, Integer> hashMap = new ConcurrentHashMap<Integer,Integer>();
        for (int i=0;i<nums.length; i++){
            if(hashMap.containsKey(target -nums[i])){
               return new int[]{hashMap.get(target-nums[i]),i};
            }
            else {
                hashMap.put(nums[i],i);
            }
        }

        return new int[2];

    }
}
