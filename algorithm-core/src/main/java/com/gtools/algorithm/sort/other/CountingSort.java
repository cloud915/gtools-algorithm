package com.gtools.algorithm.sort.other;

import java.util.Arrays;

/**
 * Created by Administrator on 2018/12/27.
 */
public class CountingSort {
    public static void main(String[] args) {

        int[] arr = {9, 8, 7, 6, 8, 4, 3, 3, 2};
        int[] res1 = countingSort2(arr);
        System.out.println(Arrays.toString(res1));

        /*arr = new int[]{9, 8, 7, 6, 8, 4, 3, 3, 1};
        int[] res2 = countingSort2(arr);
        System.out.println(Arrays.toString(res2));*/

    }

    public static int[] countingSort1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        System.out.println("the list->" + Arrays.toString(arr));

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        //找出数组中的最大最小值
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        System.out.println("max: " + max + ",min: " + min);
        int[] help = new int[max - min + 1];
        System.out.println("init help->" + Arrays.toString(help));
        //找出每个数字出现的次数
        for (int i = 0; i < arr.length; i++) {
            int mapPos = arr[i] - min;
            help[mapPos]++;
        }
        System.out.println("find help->" + Arrays.toString(help));
        System.out.println("-------------------------------------------");
        int res[] = new int[arr.length];
        int index = 0;
        for (int i = 0; i < help.length; i++) {
            System.out.println("help->" + Arrays.toString(help));
            while (help[i]-- > 0) {
                res[index++] = i + min;
                System.out.println("res->" + Arrays.toString(res));
            }
            System.out.println("-------------------------------------------");
        }

        return arr;
    }

    public static int[] countingSort2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        System.out.println("the list->" + Arrays.toString(arr));

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        //找出数组中的最大最小值
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        System.out.println("max: " + max + ",min: " + min);
        int[] help = new int[max - min + 1];
        System.out.println("init help->" + Arrays.toString(help));

        //找出每个数字出现的次数
        for (int i = 0; i < arr.length; i++) {
            int mapPos = arr[i] - min;
            help[mapPos]++;
        }
        System.out.println("find help->" + Arrays.toString(help));
        System.out.println("-------------------------------------------");
        //计算每个数字应该在排序后数组中应该处于的位置
        for (int i = 1; i < help.length; i++) {
            help[i] = help[i - 1] + help[i];
        }
        System.out.println("catal help->" + Arrays.toString(help));
        System.out.println("-------------------------------------------");

        int res[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            System.out.println("list->" + Arrays.toString(arr));
            System.out.println("help->" + Arrays.toString(help));

            int post = --help[arr[i] - min];
            System.out.println("i->" + i + ",(arr[i] - min)->"+(arr[i] - min)+",post->" + post);
            res[post] = arr[i];

            System.out.println("res->" + Arrays.toString(res));
            System.out.println("-------------------------------------------");
        }
        return res;
    }
}
