package com.gtools.algorithm.point2offer;

/**
 * @Description
 * @Author ghy
 * @Date 2020/4/24 14:38
 */
public class No25 {
    // 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
    // 要求不能创建任何新的结点，只能调整树中结点指针的指向。

    // 定义一个链表的尾节点，递归处理左右子树，最后返回链表的头节点
    public TreeNode Convert(TreeNode pRootOfTree) {
        TreeNode lastList = convertNode(pRootOfTree, null);
        TreeNode phead = lastList;
        while (phead != null && phead.left != null) {
            phead = phead.left;
        }
        return phead;
    }

    private TreeNode convertNode(TreeNode root, TreeNode lastlist) {
        if (root == null) {
            return null;
        }
        TreeNode cur = root;
        if (cur.left != null) {
            lastlist = convertNode(root.left, lastlist);
        }
        cur.left = lastlist;
        if (lastlist != null) {
            lastlist.right = cur;
        }
        lastlist = cur;
        if (cur.right != null) {
            lastlist = convertNode(cur.right, lastlist);
        }
        return lastlist;
    }

}
