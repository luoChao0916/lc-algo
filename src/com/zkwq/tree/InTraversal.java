package com.zkwq.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luochao
 * @desc (中序遍历： 对于树中的任意节点来说，先打印它的左子树，然后再打印它本身，最后打印它的右子树。)
 * @date 2023/2/7
 */
public class InTraversal {

    /**
     * 递归公式： print(left) + print(node) + + print(right)
     * 终止条件：node == null
     *
     * 时间复杂度：O(n)，其中 n 是二叉树的节点数。每一个节点恰好被遍历一次。
     * 空间复杂度：O(n)，为递归过程中栈的开销，平均情况下为 O(logn)，最坏情况下树呈现链状，为 O(n)。
     */
    private List<Integer> nodeDatas = new ArrayList<>();
    private List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return nodeDatas;
        }
        inorderTraversal(root.left);
        nodeDatas.add(root.data);
        inorderTraversal(root.right);
        return nodeDatas;
    }
}
