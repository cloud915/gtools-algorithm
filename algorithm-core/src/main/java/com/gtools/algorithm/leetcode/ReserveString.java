package com.gtools.algorithm.leetcode;

/**
 * @Description
 * @Author ghy
 * @Date 2020/4/16 11:50
 */
public class ReserveString {
    // 字符串反转
    // 输入：Hello world from beijing
    // 输出：beijing from world Hello

    public static void main(String[] args) {
        String str = "Hello world from beijing";

        System.out.println(reJuzi(str));
    }

    private static String reJuzi(String str) {
        String re1 = reString0(str.toCharArray(), 0, str.length() - 1);
        char[] array = re1.toCharArray();

        int i = 0, j = 0;
        while (j < array.length) {
            if (array[j] != ' ') {
                j++;
                if (j == array.length-1) {
                    reString0(array, i, j);
                }
            } else {
                reString0(array, i, j-1);
                j ++;
                i = j;
            }
        }
        return new String(array);
    }


    private static String reString0(char[] array, int begin, int end) {
        //char[] array = str.toCharArray();
        //int length = array.length - 1;
        for (int i = begin; i < end; i++, end--) {
            array[i] ^= array[end];
            array[end] ^= array[i];
            array[i] ^= array[end];
        }

        return new String(array);
    }
}
