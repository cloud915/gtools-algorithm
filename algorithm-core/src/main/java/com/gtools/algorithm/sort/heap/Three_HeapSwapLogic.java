package com.gtools.algorithm.sort.heap;

import com.gtools.algorithm.sort.SortUtil;

import java.util.Arrays;

/**
 * @Description 堆排序的逻辑： 构建大顶堆/小顶堆
 * 将 最右节点与 root node交换，然后遍历树，让最大值/最小值，交换到root node
 * @Author ghy
 * @Date 2020/1/16 18:51
 */
public class Three_HeapSwapLogic {
    public static void main(String[] args) {

        int[] nums = {9, 8, 1, 3, 2, 7, 6, 11, 15, 20, 18};
        System.out.println(Arrays.toString(nums));
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            // 从一半位置开始向前，向前处理，此时的流程，是堆排序中，第一次构建堆顺序的过程
            // 因为一半位置的节点，就是tree的最右侧那颗最小子树！
            // 从它开始，向前遍历，就是在整理这可树，将最大值向上调整。
            // 完毕后，root node就是最大值
            adjustHeap(nums, i, nums.length);
        }
        System.out.println(Arrays.toString(nums)); // 疑问：执行到这里，打印的内容，哪里有序？
        for (int i = nums.length - 1; i > 0; i--) {
            SortUtil.swap(nums, 0, i);
            adjustHeap(nums, 0, i);
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void adjustHeap(int[] nums, int i, int length) {
        // 1、 i 相当于 本次调用期间的堆顶
        int temp = nums[i];
        // 2、从左节点开始，对比左右节点，找到比较大的值
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            // 3、然后再与父节点对比，如果大于父节点，则修改父节点的值，再for外面再将子节点修改为 最开始记录的值
            if (k + 1 < length && nums[k] < nums[k + 1]) {
                k = k + 1;
            }
            if (nums[k] > temp) {// 此处num[k]不是与nums[i]对比，而是与 堆顶 对比，因为要符合 堆排序逻辑！！
                nums[i] = nums[k];
                i = k;
            } else {
                break;
            }
        }
        // 4、此处的i已经被修改为k的值，也就是最后一次发现大于父节点的元素的索引。
        nums[i] = temp;
    }


}
