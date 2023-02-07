package com.zkwq.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author luochao
 * @desc (前序遍历： 对于树中的任意节点来说，先打印这个节点，然后再打印它的左子树，最后打印它的右子树。)
 * @date 2023/2/7
 */
public class PreTraversal {
    /**
     * 递归公式：print(node) + print(left) + print(right)
     * 终止条件：node == null
     *
     * 时间复杂度：O(n)，其中 n 是二叉树的节点数。每一个节点恰好被遍历一次。
     * 空间复杂度：O(n)，为递归过程中栈的开销，平均情况下为 O(logn)，最坏情况下树呈现链状，为 O(n)。
     */
    private List<Integer> nodeDatas = new ArrayList<>();
    private List<Integer> preOrderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        nodeDatas.add(root.data);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
        return nodeDatas;
    }

}