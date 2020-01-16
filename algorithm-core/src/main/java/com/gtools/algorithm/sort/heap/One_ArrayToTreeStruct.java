package com.gtools.algorithm.sort.heap;

import java.util.Arrays;

/**
 * @Description 将一个数组，转换为二叉树的表示结构；保留数组顺序，转为 树的上下级关系
 * @Author ghy
 * @Date 2020/1/16 18:16
 */
public class One_ArrayToTreeStruct {

    public static void main(String[] args) {
        Node[] nums = {new Node(9), new Node(8), new Node(3), new Node(1), new Node(2), new Node(7), new Node(6)};
        System.out.println(Arrays.toString(nums));

        for (int i = 0; i < nums.length / 2 - 1; i++) {
            if (nums[i * 2 + 1] != null) {
                nums[i].left = nums[i * 2 + 1];
            }
            if (nums[i * 2 + 2] != null) {
                nums[i].right = nums[i * 2 + 2];
            }
        }

        int index = nums.length / 2 - 1;
        nums[index].left = nums[index * 2 + 1];
        if (nums.length % 2 == 1) {
            nums[index].right = nums[index * 2 + 2];
        }
        System.out.println(Arrays.toString(nums));
    }

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int val) {
            this.value = val;
        }

        @Override
        public String toString() {
            return this.value + "";
        }
    }
}
