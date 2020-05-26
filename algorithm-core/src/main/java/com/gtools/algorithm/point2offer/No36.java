package com.gtools.algorithm.point2offer;

/**
 * @Description
 * @Author ghy
 * @Date 2020/5/26 15:56
 */
public class No36 {

    // 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
    // 输入一个数组,求出这个数组中的逆序对的总数P
    //
    //思路：本质是归并排序，在比较时加入全局变量count进行记录逆序对的个数，
    // 若data[start] >= data[index] ，则count值为mid+1-start

    public static void main(String[] args) {
        int[] nums = {2, 26, 17, 18, 5, 9, 7};
        No36 n=new No36();
        System.out.println(n.InversePairs(nums));
    }

    int count = 0;

    public int InversePairs(int[] array) {
        if (array == null) return 0;
        mergeSort(array, 0, array.length - 1);
        return count;
    }

    private void mergeSort(int[] data, int start, int end) {
        int mid = (start >> 1) + (end >> 1);
        if (start < end) {
            mergeSort(data, start, mid);
            mergeSort(data, mid + 1, end);
            merge(data, start, mid, end);
        }
    }

    private void merge(int[] data, int start, int mid, int end) {
        int arr[] = new int[end - start + 1];
        int c = 0;
        int s = start;
        int index = mid + 1;
        while (start <= mid && index <= end) {
            if (data[start] < data[index]) {
                arr[c++] = data[start++];
            } else {
                arr[c++] = data[index++];
                count += mid + 1 - start;
                count %= 1000000007;
            }
        }
        while (start <= mid) {
            arr[c++] = data[start++];
        }
        while (index <= end) {
            arr[c++] = data[index++];
        }
        for (int d : arr) {
            data[s++] = d;
        }
    }


}
