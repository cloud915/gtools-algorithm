package com.gtools.algorithm.point2offer;

/**
 * @Description
 * @Author ghy
 * @Date 2020/2/16 0:27
 */
public class No16 {
    //18.输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
    //
    //思路：若根节点相等，利用递归比较他们的子树是否相等，若根节点不相等，则利用递归分别在左右子树中查找。

    public boolean HasSubtree(No6.TreeNode A, No6.TreeNode B) {
        boolean result = false;
        if (B != null && A != null) {
            if (A.val == B.val) {
                result = doesTree1HaveTree2(A, B);
            }
            if (!result) {
                return HasSubtree(A.left, B) || HasSubtree(A.right, B);
            }
        }
        return result;
    }

    private boolean doesTree1HaveTree2(No6.TreeNode node1, No6.TreeNode node2) {
        if (node2 == null) {
            return true;
        }
        if (node1 == null) {
            return false;
        }
        if (node1.val != node2.val) {
            return false;
        }
        return doesTree1HaveTree2(node1.left, node2.left) || doesTree1HaveTree2(node1.right, node2.right);
    }
}
