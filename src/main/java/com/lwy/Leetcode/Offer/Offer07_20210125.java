package com.lwy.Leetcode.Offer;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Collection;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 *  
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 *    返回：[3,9,20,null,null,15,7]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer07_20210125 {
    public static void main(String[] args) {
        final StringBuffer s = new StringBuffer("abc");
        System.out.println(s);
        s.append("aaa");
        System.out.println(s);


    }
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

/**
 *  * 前序遍历 preorder = [3,9,20,15,7]
 *  * 中序遍历 inorder = [9,3,15,20,7]
 */

/**
 * 思路：
 * 前序遍历中的第一个元素是 节点元素，再中序遍历中此节点的左边 是二叉树的左分支 右边是二叉树的右分支
 *
 *
 * 正常的二叉树遍历问题，已知前序遍历是根左右，中序遍历是左根右，则显然：前序遍历数组的第一个元素，在中序遍历中作为根，将中序数组划分左右子树两部分
 *
 * 第一步：建立根节点，在中序数组中找到inorder[len] = preorder[0]划分左右数组，并且根据len，也可以在前序数组中划分左右数组
 *
 * 第二步：在左子树执行相同操作
 *
 * 第三步：在右子树执行相同操作。
 *
 * 上诉操作很容易想到用递归，则递归实现如下，由于每次需要在中序数组中遍历找到对应元素，时间复杂度是O(n²)，考虑到栈空间，空间复杂度O(n),当然实际上我的数组复制操作也会带来额外的空间和时间浪费
 *
 * 作者：yun-yu-chen
 * 链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/solution/si-chong-si-lu-shen-ru-yu-qian-chu-di-gu-53eh/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
class Solution_offer07_01 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //判断是否为空
        if(preorder.length == 0) return null;
        //找到节点
        int flag = 0;
        while (inorder[flag] != preorder[0]){
            flag ++;
        }
        //定义边界
        int end = inorder.length;
        //传入的是节点的数
        TreeNode treeNode = new TreeNode(preorder[0]);
        //左右分支
        treeNode.left = buildTree(Arrays.copyOfRange(preorder,1,1+flag),Arrays.copyOfRange(inorder,0,flag));
        treeNode.right = buildTree(Arrays.copyOfRange(preorder,1+flag,end),Arrays.copyOfRange(inorder,flag+1,end));
        return treeNode;


    }
}
/**
 *  * 前序遍历 preorder = [3,9,20,15,7]
 *  * 中序遍历 inorder = [9,3,15,20,7]
 */

class Solution_offer07_02 {
    Map<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        //存储中序遍历所有的值和他的 下标
        for(int i = 0; i < n; i++){
            map.put(inorder[i],i);
        }
        return build(preorder,inorder,0,n-1,0,n-1);
    }
    public TreeNode build(int[] preorder, int[] inorder,int pbegin,int pend,int ibegin,int iend){
        if(pbegin > pend)
            return null;
        //存贮子节点
        TreeNode root = new TreeNode(preorder[pbegin]);
        //从map获取长度
        int len = map.get(preorder[pbegin]) - ibegin;
        root.left = build(preorder,inorder,pbegin + 1,pbegin + len,ibegin,ibegin + len - 1);
        root.right = build(preorder,inorder,pbegin + len + 1,pend,ibegin + len + 1,iend);
        return root;
    }
}


