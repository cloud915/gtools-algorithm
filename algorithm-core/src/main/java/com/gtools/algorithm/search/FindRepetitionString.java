package com.gtools.algorithm.search;

/**
 * @Description 从字符串中找出重复的字符
 * @Author ghy
 * @Date 2020/2/13 11:49
 */
public class FindRepetitionString {
    public static void main(String[] args) {
        int[] nums = {12, 23, 31, 15, 23, 66, 25};
        System.out.println(find(nums));
    }

    private static int find(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = i+1; j < nums.length; j++) {
                /*if (i == j) {
                    continue;
                }*/
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
            if (count > 0) {
                return nums[i];
            }
        }
        return -1;
    }
}
