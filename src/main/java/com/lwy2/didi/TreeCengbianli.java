package com.lwy2.didi;



import com.lwy2.entity.TreeNode;

import java.util.*;

//  https://leetcode-cn.com/problems/binary-tree-level-order-traversal/solution/die-dai-di-gui-duo-tu-yan-shi-102er-cha-shu-de-cen/
//
public class TreeCengbianli {
    /**
     * 思想 一层一层的便利
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> lists = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list_son = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                list_son.add(poll.val);  //添加到集合并删除
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);

                }
            }
            lists.add(list_son);
        }
        return lists;

    }

}
