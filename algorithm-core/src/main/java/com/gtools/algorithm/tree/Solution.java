package com.gtools.algorithm.tree;

import com.gtools.algorithm.common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 二叉树的遍历
 */
public class Solution {
    public List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        preOrderTraversal(root, result);
        return result;
    }

    /**
     * 递归实现前序遍历
     *
     * @param root
     * @param result
     */
    private void preOrderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) return;
        result.add(root.val); // 中序遍历，则是将这个操作放在中间，后序遍历是放在最后
        preOrderTraversal(root.left, result);
        preOrderTraversal(root.right, result);
    }

    /**
     * 迭代法，实现前序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> preOrderTraversal2(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) return result;

        Stack<TreeNode> toVisit = new Stack<>();
        toVisit.push(root);
        TreeNode cur;
        while (!toVisit.isEmpty()) {
            cur = toVisit.pop();
            result.add(cur.val);
            if (cur.left != null) toVisit.push(cur.left);
            if (cur.right != null) toVisit.push(cur.right);
        }
        return result;
    }

    /**
     * 迭代法，实现中序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> inOrderTraversal2(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) return result;

        Stack<TreeNode> toVisit = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !toVisit.isEmpty()) {
            while (cur != null) {
                toVisit.push(cur); // 添加根节点
                cur = cur.left; // 循环添加左节点
            }
            cur = toVisit.pop(); // 当前栈顶已经是最底层的左节点了，取出栈顶元素，访问该节点
            result.add(cur.val);
            cur = cur.right; // 添加右节点
        }
        return result;
    }

    /**
     * 迭代法，实现后序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> toVisit = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;

        while (cur != null || !toVisit.isEmpty()) {
            while (cur != null) {
                toVisit.push(cur);
                cur = cur.left;
            }
            cur = toVisit.peek();// 访问栈顶元素，但不弹出，也就是tree的最左节点

            //在不存在右节点或者右节点已经访问过的情况下，访问根节点
            if (cur.right == null || cur.right == pre) {
                toVisit.pop();// 出栈
                result.add(cur.val);
                pre = cur;
                cur = null;
            } else {
                cur = cur.right;
            }
        }
        return result;
    }

    /**
     * 递归，层序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> levelOrderTraversal(TreeNode root) {
        if (root == null) return null;
        return null;
    }

    /*
     * 迭代，层序遍历
     *
     */
    public void levelOrderTraversal2(TreeNode root) {
        if (root == null) return;
        TreeNode cur;
        Queue<TreeNode> queue = new LinkedBlockingQueue<>(); // 利用队列的先进先出
        queue.add(root);

        while (!queue.isEmpty()) {
            cur = queue.poll();
            System.out.println(cur.val + ",");

            if (cur.left != null) queue.add(cur.left);
            if (cur.right != null) queue.add(cur.right);
        }
    }

    /*
     * 层序遍历
     * 递归
     */
    public void levelOrder(TreeNode Node) {
        if (Node == null) {
            return;
        }

        int depth = depth(Node);

        for (int i = 1; i <= depth; i++) {
            levelOrder(Node, i);
        }
    }

    private void levelOrder(TreeNode Node, int level) {
        if (Node == null || level < 1) {
            return;
        }

        if (level == 1) {
            System.out.print(Node.val + "  ");
            return;
        }

        // 左子树
        levelOrder(Node.left, level - 1);

        // 右子树
        levelOrder(Node.right, level - 1);
    }

    public int depth(TreeNode Node) {
        if (Node == null) {
            return 0;
        }

        int l = depth(Node.left);
        int r = depth(Node.right);
        if (l > r) {
            return l + 1;
        } else {
            return r + 1;
        }
    }


}
