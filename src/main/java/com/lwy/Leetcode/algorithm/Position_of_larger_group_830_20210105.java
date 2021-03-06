package com.lwy.Leetcode.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 在一个由小写字母构成的字符串 s 中，包含由一些连续的相同字符所构成的分组。
 *
 * 例如，在字符串 s = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
 *
 * 分组可以用区间 [start, end] 表示，其中 start 和 end 分别表示该分组的起始和终止位置的下标。上例中的 "xxxx" 分组用区间表示为 [3,6] 。
 *
 * 我们称所有包含大于或等于三个连续字符的分组为 较大分组 。
 *
 * 找到每一个 较大分组 的区间，按起始位置下标递增顺序排序后，返回结果。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "abbxxxxzzy"
 * 输出：[[3,6]]
 * 解释："xxxx" 是一个起始于 3 且终止于 6 的较大分组。
 * 示例 2：
 *
 * 输入：s = "abc"
 * 输出：[]
 * 解释："a","b" 和 "c" 均不是符合要求的较大分组。
 * 示例 3：
 *
 * 输入：s = "abcdddeeeeaabbbcd"
 * 输出：[[3,5],[6,9],[12,14]]
 * 解释：较大分组为 "ddd", "eeee" 和 "bbb"
 * 示例 4：
 *
 * 输入：s = "aba"
 * 输出：[]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/positions-of-large-groups
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Position_of_larger_group_830_20210105 {
    public static void main(String[] args) {
        Solution_830 solution830 = new Solution_830();
        List<List<Integer>> lists = solution830.largeGroupPositions("pppmmmm");
        lists.forEach(System.out::print);

    }}

class Solution_830 {


    public List<List<Integer>> largeGroupPositions(String s) {

        List<List<Integer>> list = new CopyOnWriteArrayList<>();

        ArrayList<Object> arrayList = new ArrayList<>();

//        s = s+" ";

        for(int i=0;i<s.length();i++){

           arrayList.add(s.substring(i,i+1));

        }
        int flag= 0;
        while (flag < s.length()-2){



            if(arrayList.get(flag).equals(arrayList.get(flag+1)) && arrayList.get(flag).equals(arrayList.get(flag+2))){
                int over = -100 ;
                int begin = flag;
                //技数
                int fornum = 0;
                for (int i=1;i<=s.length()-(flag+1+2);i++){
                    if(arrayList.get(flag).equals(arrayList.get(flag+2+i))){
                        over = flag+2+i;
                        fornum ++;
                    }
                    else {
                        break;
                    }
                }
                if(over == -100){
                    over = flag + 2;
                }
                flag += fornum +2;

                ArrayList<Integer> list1 = new ArrayList<>();
                list1.add(begin);
                list1.add(over);
                list.add(list1);

                flag+=1;
            }
            else {

                flag+=1;
            }

        }


        return list;

    }
}
