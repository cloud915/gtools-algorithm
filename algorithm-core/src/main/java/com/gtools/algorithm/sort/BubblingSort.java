package com.gtools.algorithm.sort;

/**
 * @Description 冒泡排序
 * @Author ghy
 * @Date 2020/1/9 14:44
 */
public class BubblingSort {

    public static void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length-1; j > i; j--) {
                if (nums[i] > nums[j]) {
                    SortUtil.swap(nums, i, j);
                }
            }
        }
    }
}
