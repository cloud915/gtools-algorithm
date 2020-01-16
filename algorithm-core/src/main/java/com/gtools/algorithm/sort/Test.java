package com.gtools.algorithm.sort;

import java.util.Arrays;

/**
 * @Description
 * @Author ghy
 * @Date 2020/1/16 11:06
 */
public class Test {
    public static void main(String[] args) {
        int[] nums = {22, 13, 25, 32, 1, 20, 18, 33, 65, 42};
        //BubblingSort.sort(nums);
        //QuickSort.sort(nums, 0, nums.length - 1);
        MergeSort.sort(nums);
        System.out.println(Arrays.toString(nums));

        // 取平均值、中间值
        //int a=101+((202-101)>>1);
        //System.out.println(a);
    }
}
