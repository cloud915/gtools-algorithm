package com.gtools.algorithm.sort.other;

import java.util.Arrays;

/**
 * Created by Administrator on 2018/12/27.
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 7, 9, 8, 3, 6};
        sort(arr);
        System.out.println(Arrays.toString(arr));

        int[] arr1 = {1, 4, 2, 7, 9, 8, 3, 6};
        sort1(arr1);
        System.out.println(Arrays.toString(arr1));
    }

    public static void sort(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                while (j - gap >= 0 && arr[j] < arr[j - gap]) {
                    BaseSort.swap(arr, j, j - gap);
                    j -= gap;
                }
            }
        }
    }

    public static void sort1(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    arr[j] = temp;
                }
            }
        }
    }

}
