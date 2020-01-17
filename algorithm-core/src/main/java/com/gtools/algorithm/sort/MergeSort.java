package com.gtools.algorithm.sort;

/**
 * @Description 归并排序
 * @Author ghy
 * @Date 2020/1/16 13:56
 */
public class MergeSort {

    public static void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    private static void sort(int[] nums, int left, int right) {
        if (right > left) {
            //int mid = right - left == 1 ? right : left + ((right - left) >> 1); // 有问题
            int mid = left + ((right - left) >> 1);
            sort(nums, left, mid);
            sort(nums, mid + 1, right);
            merge(nums, left, mid, right);
        }
    }

    /**
     * 将数组拆分到最小后，按大小顺序合并 左(left -- mid)右(mid+1 -- right) 两个序列
     *
     * @param nums
     * @param left
     * @param mid
     * @param right
     */
    private static void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[nums.length];
        int i = left;//左序列指针
        int j = mid + 1;//右序列指针
        int t = 0;//临时数组指针

        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[t++] = nums[i++];
            } else {
                temp[t++] = nums[j++];
            }
        }
        while (i <= mid) {//将左边剩余元素填充进temp中
            temp[t++] = nums[i++];
        }
        while (j <= right) {//将右序列剩余元素填充进temp中
            temp[t++] = nums[j++];
        }
        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while (left <= right) {
            nums[left++] = temp[t++];
        }
    }
}
