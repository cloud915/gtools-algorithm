package com.gtools.algorithm.search;

/**
 * @Description
 * @Author ghy
 * @Date 2020/1/9 14:41
 */
public class TwoSplitSearch {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("数字7，在数组中的索引是：" + search(nums, 0, nums.length, 7));
    }

    public static int search(int[] nums, int head, int tail, int val) {
        int mid = head + tail >>> 1;
        if (nums[mid] < val) {
            return search(nums, mid, tail, val);
        } else if (nums[mid] > val) {
            return search(nums, head, mid, val);
        } else {
            return mid;
        }
    }
}
