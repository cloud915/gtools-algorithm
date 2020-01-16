package com.gtools.algorithm.sort;

/**
 * @Description
 * @Author ghy
 * @Date 2020/1/16 11:25
 */
public class QuickSort {
    public static void sort(int[] nums, int low, int high) {
        if (low >= high) return;

        int i = low, j = high;
        int temp = nums[low];

        while (i < j) {
            // 因为取的 flag 是num[low],因此从尾部开始对比
            while (nums[j] >= temp && i < j) {
                j--;
            }
            while (nums[i] <= temp && i < j) {
                i++;
            }
            if (i < j) {
                SortUtil.swap(nums, i, j);
            }
        }
        nums[low] = nums[i];
        nums[i] = temp;

        // j是高位，从高位进行分割，前半部分和后半部分 分别排序
        sort(nums, low, j - 1);
        sort(nums, j + 1, high);

    }
}
