package com.zkwq.tree;

/**
 * @author luoChao
 * @create_date 2020-04-08 23:27
 */
public class LcBSTree {
    // 根节点
    private Node root;

    /**
     * 树为空，直接创建只含有根节点的树
     * 将要插入的数据和节点的值比较并根据结果来决定来插入到左节点或右节点
     * 如果左节点或者右节点为null,直接插入，否则再循环上面的动作
     * 插入的查找差不多
     * @param data 要插入的数据
     */
    private void insert(int data) {
        if (root == null) {
            root = new Node(data);
            return;
        }
        Node tree = root;
        while (tree != null) {
            if (data < tree.data) {
                if (tree.left == null) {
                    tree.left = new Node(data);
                    return;
                }
                tree = tree.left;
            } else {
                if (tree.right == null) {
                    tree.right = new Node(data);
                    return;
                }
                tree = tree.right;
            }
        }
    }

    /**
     * 中序遍历顺序：左子树、根节点、右子树
     * @param root 二叉搜索树根节点
     */
    private void inorderTraversal(Node root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        System.out.print(root.data + " ");
        inorderTraversal(root.right);
    }

    private class Node {
        private int data;
        private Node left;
        private Node right;

        private Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        LcBSTree lcBSTree = new LcBSTree();
        lcBSTree.insert(4);
        lcBSTree.insert(3);
        lcBSTree.insert(7);
        lcBSTree.insert(1);
        lcBSTree.insert(5);
        lcBSTree.insert(8);
        lcBSTree.inorderTraversal(lcBSTree.root);
    }
}
