package com.gtools.algorithm.sort;

import java.util.Arrays;

/**
 * @Description 小顶堆
 * @Author ghy
 * @Date 2020/1/16 18:03
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] nums = SortUtil.randomArray(20, 100);
        System.out.println(Arrays.toString(nums));
        //long a = System.currentTimeMillis();
        // 调整整棵树，从最右侧最小子树开始
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            adjustHeap(nums, i, nums.length);
        }
        // 从最右侧最小子树的子节点开始（也就是数组的最后一个元素，反向遍历），进行排序操作（root node与 last node进行交换，并重构整棵树）
        for (int m = nums.length - 1; m > 0; m--) {
            SortUtil.swap(nums, 0, m);// 交换“根节点”与“last node”
            adjustHeap(nums, 0, m);// 此处第三个参数length=m，是控制树的调整范围，因为已经经历过x次for循环的节点是有序的，就不需要再进行adjustHeap了
        }
        //System.out.println(System.currentTimeMillis() - a);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 经过堆排序后，tree的root node 是最大值/最小值
     * 从数组角度看，如果是大顶堆，那么经过swap调整后，最大值从数组第一个节点，交换到最后一个节点
     * @param nums
     * @param i
     * @param length
     */
    private static void adjustHeap(int[] nums, int i, int length) {
        // 保留本次操作的tree的“根节点”
        int temp = nums[i];
        // 左节点与右节点，在数组角度看，距离相差1
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && nums[k] >= nums[k + 1]) {
                k = k + 1;
            }
            if (nums[k] < temp) { // 将最小子树中最大值转移到“根节点”
                nums[i] = nums[k];
                i = k; // 这里与 for外层的 两次赋值 有关，
                // 因为i的值变化为k的值，也就是目标节点一直在移动，但是值，只是赋值到i之前的位置，本身k位置的值没变，随着移动，一直有2个节点的value是一样的
                // 那么在完全移动完，最后值相同的节点的位置就是 目标节点的位置，在for外面需要赋值一下。
            }
        }

        // 通过上方遍历，找到整棵树的最大值，并移动到最顶部，但是移动过程，最下方的节点值丢失，设置为第一步缓存的值
        nums[i] = temp;
    }
}
