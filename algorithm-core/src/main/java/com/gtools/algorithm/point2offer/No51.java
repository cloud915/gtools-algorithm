package com.gtools.algorithm.point2offer;

/**
 * @Description
 * @Author ghy
 * @Date 2020/5/26 19:03
 */
public class No51 {
    // 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
    // 数组中某些数字是重复的，但不知道有几个数字是重复的。
    // 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
    // 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。

    // 思路：若下标大于length，则减去length，最后再加上length，若下标的数组值大于length，则返回true。或使用辅助空间（HashSet）

    public boolean duplicate(int numbers[], int length, int[] duplication) {
        if (numbers == null || length == 0 || length == 1)
            return false;
        for (int i = 0; i < length; i++) {
            int index = numbers[i];
            if (index >= length)
                index -= length;
            if (numbers[index] >= length) {
                duplication[0] = index;
                return true;
            }
            numbers[index] += length;
        }
        return false;
    }

}
