package com.gtools.algorithm.web;

public class findRepeatNum {
    // 数组中找出不重复的1个数字
    // 思路： 异或操作，如果相同的数字，会等于0


    // 数组中找出不重复的2个数字


    public static void main(String[] args) {
        int[] arr = {2, 4, 3, 6, 3, 2, 5, 6, 5};
        System.out.println(findNotRepeat(arr));
    }

    private static int findNotRepeat(int[] arr) {
        int len = arr.length;
        int res = -1;
        if (len > 1) {
            res = arr[0];
            for (int i = 1; i < len; i++) {
                res = res ^ arr[i];
            }
        }
        return res;
    }

}
