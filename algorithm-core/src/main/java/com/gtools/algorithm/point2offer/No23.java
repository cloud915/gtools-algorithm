package com.gtools.algorithm.point2offer;

import java.util.ArrayList;

/**
 * @Description
 * @Author ghy
 * @Date 2020/5/22 13:59
 */
public class No23 {
    // 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
    // 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
    // 思路：先保存根节点，然后分别递归在左右子树中找目标值，若找到即到达叶子节点，打印路径中的值


    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
        if (root == null)
            return arr;
        ArrayList<Integer> a1 = new ArrayList<Integer>();
        int sum = 0;
        pa(root, target, arr, a1, sum);
        return arr;
    }

    private void pa(TreeNode root, int target, ArrayList<ArrayList<Integer>> arr, ArrayList<Integer> a1, int sum) {
        if (root == null)
            return;
        sum += root.val;

        if (root.left == null && root.right == null) {
            if (sum == target) {
                a1.add(root.val);
                arr.add(new ArrayList<Integer>(a1));
                a1.remove(a1.size() - 1);
            }
            return;
        }

        a1.add(root.val);
        pa(root.left, target, arr, a1, sum);
        pa(root.right, target, arr, a1, sum);
        a1.remove(a1.size() - 1);
    }
}
