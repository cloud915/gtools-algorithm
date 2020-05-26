package com.gtools.algorithm.point2offer;

import sun.security.util.Length;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description
 * @Author ghy
 * @Date 2020/5/22 15:16
 */
public class No28 {
    // 输入n个整数，找出其中最小的K个数。
    //
    //思路：先将前K个数放入数组，进行堆排序，若之后的数比它还小，则进行调整

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input == null || k <= 0 || k > input.length) {
            return list;
        }

        int[] kArray = Arrays.copyOfRange(input, 0, k);
        buildHeap(kArray);

        for (int i = k; i < input.length; i++) {
            if (input[i] < kArray[0]) {
                kArray[0] = input[i];
                maxHeap(kArray, 0);
            }
        }

        for (int i = kArray.length - 1; i >= 0; i--) {
            list.add(kArray[i]);
        }
        return list;
    }

    private void buildHeap(int[] input) {
        for (int i = input.length / 2 - 1; i >= 0; i--) {
            maxHeap(input, i);
        }
    }

    private void maxHeap(int[] array, int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = 0;

        if (left < array.length && array[left] > array[i]) {
            largest = left;
        } else {
            largest = i;
        }

        if (right < array.length && array[right] > array[largest]) {
            largest = right;
        }
        if (largest != i) {
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;
            maxHeap(array, largest);
        }
    }

    public static void main(String[] args) {
        No28 n = new No28();
        int[] nums = {9,2, 4, 6, 1, 3, 7, 5, 8,12,18};
        List<Integer> list = n.GetLeastNumbers_Solution(nums, 5);
        System.out.println(Arrays.toString(list.toArray()));
    }
}
