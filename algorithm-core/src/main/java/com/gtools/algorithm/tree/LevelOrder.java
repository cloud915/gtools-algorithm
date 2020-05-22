package com.gtools.algorithm.tree;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Description
 * @Author ghy
 * @Date 2020/5/18 10:11
 */
public class LevelOrder {
    /*
     * 层序遍历方法
     * 参数为二叉树的根节点
     */
    public static void levelOrder(BiTreeNode t) {
        if (t == null)
            return;
        // 依賴的是隊列的先進先出特點
        Queue<BiTreeNode> queue = new LinkedBlockingQueue<>();
        BiTreeNode curr;
        queue.add(t);
        while (!queue.isEmpty()) {
            curr = queue.remove();
            System.out.println(curr.value);
            if (curr.left != null)
                queue.add(curr.left);
            if (curr.right != null)
                queue.add(curr.right);
        }
    }

    public static void main(String[] args) {
        //创建二叉树
        BiTreeNode t = new BiTreeNode("A");
        t.left = new BiTreeNode("B");
        t.right = new BiTreeNode("C");
        t.left.left = new BiTreeNode("D");
        t.left.left.right = new BiTreeNode("G");
        t.right.left = new BiTreeNode("E");
        t.right.right = new BiTreeNode("F");

        //执行层序遍历方法
        levelOrder(t);
    }

}

//创建二叉树类
class BiTreeNode {

    String value; //结点值
    BiTreeNode left; //左子树结点
    BiTreeNode right; //右子树结点

    public BiTreeNode(String value) { //构造方法
        this.value = value;
    }

}