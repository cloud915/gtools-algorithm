package com.gtools.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 判断能否从数组中找出两个数字和为给定值
 * @Author ghy
 * @Date 2020/1/9 14:43
 */
public class No1 {
    public static void main(String[] args) {
        int[] nums = {1, 12, 31, 42, 50, 4, 7, 8, 9};
        int sum = 54;
        List<ResObj> result = new ArrayList<ResObj>();
        for (int i = 0; i < nums.length; i++) {
            int tmp = sum - nums[i];
            for (int j = i; j < nums.length; j++) {
                if (tmp == nums[j] && i != j) {
                    result.add(new ResObj(nums[i], nums[j]));
                }
            }
        }
        System.out.println(result);
    }

    static class ResObj {
        private int a;
        private int b;

        public ResObj(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString() {
            return "a="+a+",b="+b;
        }
    }

}
