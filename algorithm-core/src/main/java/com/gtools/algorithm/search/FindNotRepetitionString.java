package com.gtools.algorithm.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 从字符串中找出不重复的字符
 * @Author ghy
 * @Date 2020/2/13 11:49
 */
public class FindNotRepetitionString {
    public static void main(String[] args) {
        int[] nums = {11, 23, 11, 25, 23, 66, 25};
        System.out.println(find(nums));

    }

    private static int find(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
            if (count == 0) {
                return nums[i];
            }
        }
        return -1;
    }
}
