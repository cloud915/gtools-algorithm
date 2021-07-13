package com.gtools.algorithm.point2offer;

import com.gtools.algorithm.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @Description
 * @Author ghy
 * @Date 2020/5/27 10:43
 */
public class No61 {
    // 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
    //
    //思路：利用辅助空间链表或队列来存储节点，每层输出。

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null)
            return res;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        ArrayList<Integer> list = new ArrayList<>();
        int start = 0;
        int end = 1;

        while (!queue.isEmpty()) {
            TreeNode node = queue.pop();
            list.add(node.val);
            start++;
            if (node.left != null)
                queue.offer(node.left);
            if (node.right != null)
                queue.offer(node.right);

            if (start == end) {
                start = 0;
                end = queue.size();
                res.add(new ArrayList<>(list));
                list.clear();
            }
        }
        return res;
    }

}
