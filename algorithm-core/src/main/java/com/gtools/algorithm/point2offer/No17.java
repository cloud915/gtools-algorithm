package com.gtools.algorithm.point2offer;

/**
 * @Description
 * @Author ghy
 * @Date 2020/2/16 11:07
 */
public class No17 {
    //操作给定的二叉树，将其变换为源二叉树的镜像。

    public void Mirror(No6.TreeNode root) {
        if (root == null) {
            return;
        }
        Mirror(root.left);
        Mirror(root.right);

        No6.TreeNode t = root.left;
        root.left = root.right;
        root.right = t;
    }
}
