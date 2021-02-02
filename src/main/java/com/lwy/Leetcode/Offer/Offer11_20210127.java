package com.lwy.Leetcode.Offer;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 *
 * 示例 1：
 *
 * 输入：[3,4,5,1,2]
 * 输出：1
 * 示例 2：
 *
 * 输入：[2,2,2,0,1]
 * 输出：0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer11_20210127 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,3,3};
        Solution_offer11 offer11 = new Solution_offer11();
        int i = offer11.minArray(arr);
        System.out.println(i);
    }
}

/**
 * 思路 首先看好题，题中给出原始数组是一个递增数组，所以设定双指针，左边开始应该依次递增，右边开始应该依次递减，直到找到中间数为止。
 */
class Solution_offer11 {
    public int minArray(int[] numbers) {
       if(numbers.length!= 0 && numbers!= null && numbers.length>3){
            boolean flag = false;
            //返回值
            int p = numbers[0];
            //是不是全等
            int t = 0;
            //是不是递增
            int k = 0;
            for (int i=0;i<numbers.length -1;i++){
                if (numbers[i] == numbers[i+1]){
                    t++;
                }
                if(numbers[i] <= numbers[i+1]){
                    k++;
                }
            }
            if (t == numbers.length -1 || k == numbers.length-1){
                flag = true;
            }

            int left = 0;
            int right = numbers.length -1;
            while (left != right && !flag){
                while (numbers[left] <= numbers[left+1] && left < right && left < numbers.length -2){
                    left ++;
                }
                while (numbers[right] >= numbers[right-1] && left < right && right > 0){
                    right --;
                }
                if (left +1 == right){
                    p = numbers[right];
                    break;
                }
            }

            return p;
        }
        else if(numbers.length == 1){
            return numbers[0];
        }
        else if(numbers.length == 2){
            if (numbers[0] > numbers[1]){
                return numbers[1];
            }
            else {
                return numbers[0];
            }
        }
        else {
            int j=0;
            for (int i=0;i<2;i++){
                if(numbers[i] > numbers[i+1]){
                    j = i+1;
                }
            }
            return numbers[j];
        }

    }
}