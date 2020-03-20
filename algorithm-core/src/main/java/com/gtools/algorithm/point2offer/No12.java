package com.gtools.algorithm.point2offer;

import java.util.Arrays;

/**
 * @Description
 * @Author ghy
 * @Date 2020/2/15 22:58
 */
public class No12 {

    // 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
    // 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
    // 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
    public static void main(String[] args) {
        No12 no = new No12();
        int[] nums = {1, 2, 12, 4, 5, 6, 7};
        //System.out.println(Arrays.toString(no.reOrderArray(nums)));
        no.reOrderArray(nums);
    }

    /*public int[] reOrderArray(int[] array) {
        int[] help = new int[array.length];
        int head = 0;
        int tail = array.length - 1;
        int[] help2 = new int[array.length];
        for (int num : array) {
            if (num % 2 != 0) {
                help[head++] = num;
            } else {
                help2[tail--] = num;
            }
        }
        for (int i = help2.length - 1; i > tail; i--) {
            help[i] = help2[i];
        }
        return help;

    }*/
    public void reOrderArray(int[] array) {

        if (array == null || array.length == 0) {
            return ;
        }

        for (int i = 1; i < array.length; i++) {
            int j = i - 1;
            if (array[i] % 2 != 0) {
                while (j >= 0) {
                    if (array[j] % 2 != 0) {
                        break;
                    }
                    if (array[j] % 2 == 0) {
                        int t = array[j + 1];
                        array[j + 1] = array[j];
                        array[j] = t;
                        j--;
                    }
                }
            }
        }
        System.out.println(array);
    }
}
