package com.gtools.algorithm.point2offer;



/**
 * @Description
 * @Author ghy
 * @Date 2020/5/26 16:44
 */
public class No38 {
    // 统计一个数字在排序数组中出现的次数。
    //
    // 思路：利用二分查找+递归思想，进行寻找。当目标值与中间值相等时进行判断

    public static void main(String[] args) {

        int[] nums = {2, 5, 6, 6, 6, 7, 8};
        No38 n = new No38();
        System.out.println(n.GetNumberOfK(nums, 6));
    }

    public int GetNumberOfK(int[] array, int k) {
        int result = 0;
        if (array == null || array.length == 0) return result;
        if(array.length == 1) {
            if(array[0] == k)
                return 1;
            else
                return 0;
        }

        int index = getIndex(array, 0, array.length - 1, k);
        int idx = index;
        while (idx > 0 && array[idx - 1] == k) {
            idx--;
        }
        index = idx;
        for (int i = index; i < array.length; i++) {
            if (array[i] == k)
                result++;
            else
                break;
        }
        return result;
    }

    public int getIndex(int[] array, int start, int end, int k) {
        int mid = (start >> 1) + (end >> 1);
        if (array[mid] > k) {
            return getIndex(array, start, mid, k);
        } else if (array[mid] < k) {
            return getIndex(array, mid + 1, end, k);
        } else {
            return mid;
        }
    }

}
