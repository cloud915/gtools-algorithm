package com.gtools.algorithm.sort;

/**
 * @Description
 * @Author ghy
 * @Date 2020/1/16 11:08
 */
public class SortUtil {
    public static void swap(int[] nums, int i, int j) {
        nums[j] = nums[i] + nums[j];
        nums[i] = nums[j] - nums[i];
        nums[j] = nums[j] - nums[i];
    }
}
