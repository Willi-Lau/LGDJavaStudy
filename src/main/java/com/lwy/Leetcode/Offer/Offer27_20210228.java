package com.lwy.Leetcode.Offer;

/**
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
 * 例如输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 镜像输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 *  
 *
 * 示例 1：
 *
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer27_20210228 {
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *
 * 思路：二叉树中序遍历
 * 中序遍历二叉树原理
 * public void inOrderTraversal(TreeNode node) {
 *     if (node == null)
 *         return;
 *     inOrderTraversal(node.left);
 *     System.out.println(node.val);
 *     inOrderTraversal(node.right);
 * }
 *
 * 作者：sdwwld
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/solution/4chong-jie-jue-fang-shi-bfsdfszhong-xu-bian-li-di-/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
class Solution_offer27 {
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null) return null;
        mirrorTree(root.left);
        //交换左右
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;
        //右边遍历
        mirrorTree(root.left);
        return root;

    }
}
