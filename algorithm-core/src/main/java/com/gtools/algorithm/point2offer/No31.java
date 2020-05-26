package com.gtools.algorithm.point2offer;

/**
 * @Description
 * @Author ghy
 * @Date 2020/5/26 15:17
 */
public class No31 {
    // 求连续子数组（包含负数）的最大和

    //思路：若和小于0，则将最大和置为当前值，否则计算最大和。

    public static void main(String[] args) {
        int[] nums = {2, 10, -1, 0, -11, 5};
        System.out.println(findGreatestSumOfSubArray(nums));
    }

    public static int findGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) return 0;
        int cur = array[0];
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (cur < 0) {
                cur = array[i];
            } else {
                cur += array[i];
            }

            if (cur > max) {
                max = cur;
            }
        }
        return max;
    }
}
