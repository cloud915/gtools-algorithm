package com.gtools.algorithm.sort.other;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertSort {
    public static <T extends Comparable<? super T>> void insertSort(T[] a) {
        for (int p = 1; p < a.length; p++) {
            T tmp = a[p];
            int j;
            for (j = p; j > 0 && tmp.compareTo(a[j - 1]) < 0; j--) {
                a[j] = a[j - 1];// 将满足条件的前面的值，后移一位；下次对比时会进行j--，也就无影响
            }
            a[j] = tmp;
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {34, 8, 64, 51, 32, 21};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
