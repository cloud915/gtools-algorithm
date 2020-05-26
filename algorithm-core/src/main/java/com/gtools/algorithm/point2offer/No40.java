package com.gtools.algorithm.point2offer;

/**
 * @Description
 * @Author ghy
 * @Date 2020/5/26 17:08
 */
public class No40 {
    // 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
    //
    //在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树


    public boolean IsBalanced_Solution(TreeNode root) {
        int left = getHight(root.left);
        int right = getHight(root.right);
        if (Math.abs(left - right) > 1) {
            return false;
        }

        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }


    public int getHight(TreeNode node) {
        if (node.left == null && node.right == null) {
            return 0;
        }
        int left = getHight(node.left);
        int right = getHight(node.right);
        return left > right ? left + 1 : right + 1;
    }
}
