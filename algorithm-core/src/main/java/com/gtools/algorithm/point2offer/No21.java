package com.gtools.algorithm.point2offer;

import com.gtools.algorithm.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * @Description
 * @Author ghy
 * @Date 2020/4/24 14:18
 */
public class No21 {
    // 从上往下打印出二叉树的每个节点，同层节点从左至右打印。

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {//注意：空树返回一个默认构造的空LinkedList，而不是一个空指针null
            return list;
        }

        queue.offer(root);
        TreeNode current;
        while (!queue.isEmpty()) {
            current = queue.poll();
            list.add(current.val);
            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
        return list;
    }
}
