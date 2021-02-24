package com.lwy.Leetcode.Offer;

/**
 * 剑指 Offer 26. 树的子结构
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 * 例如:
 * 给定的树 A:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 B：
 *
 *    4 
 *   /
 *  1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 *
 * 示例 1：
 *
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 * 示例 2：
 *
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer26_20210224 {
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution_offer26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
            if(B == null || A == null) return false;
            //遍历每一个节点 通过自身递归 依次查找
            return isSon(A,B) || isSubStructure(A.right,B) ||isSubStructure(A.left,B);
    }

    //判断是不是子结构
    public boolean isSon(TreeNode A,TreeNode B){
        //如果B树到底了说明是TURE
        if(B == null) return true;
        //A到底 FALSE
        if(A == null) return false;
        //A得值不等于B的值 这条路断了
        if(A.val != B.val) return false;

        return isSon(A.left,B.left) && isSon(A.right,B.right);
    }
}
