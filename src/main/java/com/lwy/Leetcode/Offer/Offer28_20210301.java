package com.lwy.Leetcode.Offer;

/**
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer28_20210301 {
    public static void main(String[] args) {

    }
}
/**
 * 思路：我们只需要编写一个辅助函数来递归判断当前的两个左右节点是否相等以及他们各自的左右节点是否构成对对称即可
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution_offer28 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;

        return istrue(root.left,root.right);
    }

    public boolean istrue(TreeNode left,TreeNode right){
        //左右都是空  返回true
        if(left == null && right == null){
            return true;
        }
        //左右相等 才能接着判断
        else if(left != null && right!= null && left.val == right.val){

            return istrue(left.right,right.left) && istrue(left.left,right.right);
        }
        else {
            return false;
        }

    }
}
