package com.gtools.algorithm.sort.other;

/**
 * Created by Administrator on 2018/12/26.
 */
public class BaseSort {

    public static void print(int[] arr,String msg) {
        System.out.println(msg);
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    /**
     * 交换数组元素
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int []arr,int a,int b){
        arr[a] = arr[a]+arr[b];
        arr[b] = arr[a]-arr[b];
        arr[a] = arr[a]-arr[b];
    }
}
