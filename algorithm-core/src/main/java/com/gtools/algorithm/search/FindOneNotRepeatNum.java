package com.gtools.algorithm.search;

/**
 * @Description 找到唯一不重复的数字
 * @Author ghy
 * @Date 2020/2/13 16:09
 */
public class FindOneNotRepeatNum {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 3, 1};
        System.out.println(find(nums));
    }

    private static int find(int[] nums) {
        int len = nums.length;
        int res = -1;
        if (len > 1) {
            res = nums[0];
            for (int i = 1; i < len; i++) {
                res = res ^ nums[i];
            }
        }
        return res;
    }
}
