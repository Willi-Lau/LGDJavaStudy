package com.lwy.Leetcode.Offer;

/**
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *
 *
 *
 * 示例：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 */
public class  Offer21_20210222 {
}

/**
 * 思路 类似快排序 左指针找奇数 右指针找偶数 然后换位
 */
class Solution_offer21 {
    public int[] exchange(int[] nums){
        int left = 0;
        int right = nums.length-1;

        while (left <right){
            while (nums[left]%2 != 0 && left<right){
                left++;
            }
            while (nums[right]%2 == 0 && left < right){
                right--;
            }
            if(left<right){
                int t = nums[left];
                nums[left] = nums[right];
                nums[right] = t;
            }

        }

        return nums;
    }
}