package com.gtools.algorithm.point2offer;

import java.lang.reflect.Modifier;

/**
 * @Description
 * @Author ghy
 * @Date 2020/5/22 14:57
 */
public class No27 {
    // 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字
    //
    //思路：将首次出现的数count+1，与之后的数进行比较，相等则+1，否则—1，最后进行校验是否超过长度的一半。
    public static int MoreThanHalfNum_Solution(int[] array) {
        int maxCount = array[0];
        int number = array[0];
        int count = 1;

        for (int i = 1; i < array.length; i++) {
            if (number != array[i]) {
                if (count == 0) {
                    number = array[i];
                    count = 1;
                } else {
                    count--;
                }
            } else {
                count++;
            }
            if (count == 1) {
                maxCount = number;
            }
        }
        int num = 0;
        for (int j = 0; j < array.length; j++) {
            if (array[j] == maxCount) {
                num++;
            }
        }
        if (num * 2 > array.length) {
            return maxCount;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] aa={1,2,3,2,2,3,2,5,2,2};
        System.out.println(MoreThanHalfNum_Solution(aa));
    }
}
