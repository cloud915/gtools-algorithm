package com.gtools.algorithm.search;

/**
 * @Description 寻找数组中重复的数字
 * 题目：
 * 在一个长度为n的数组里的所有数字都在0~n-1范围内。
 * 数组中某些数字是重复的。但是不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3},那么对应输出的是重复的数字2或者3。
 * @Author ghy
 * @Date 2020/2/13 14:40
 */
public class FindRepetitionNum {

    /*
    * 算法执行过程：
        以{2,3,1,0,2,5,3}为例
        数组的第0个数字（从0开始计数，和数组的下标保持一致）是2，与它的下标值不相等，于是它
        和下标为2的1进行比较，不相等，因此将2和下标为2的1进行交换。交换后的数组是{1,3,2,0,2,5,3},
        此时第0个数字1依旧和下标值不相等，于是将1和下标为1的3进行比较，不相等，因此将1和下标
        为1的3进行交换，交换后的数组为{3,1,2,0,2,5,3}。重复上述步骤继续进行交换，交换后数组
        为{0,1,2,3,2,5,3},接下来扫描的是下标为4 的2,2和下标值不同，因此将2和下标为2的2进行
        比较发现相同，则将2存储，此时已经发现重复值，程序结束。
    * */

    private static int a;

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        if (duplicate(nums)) {
            System.out.println("重复值为：" + a);
        } else {
            System.out.println("无重复值");
        }
    }

    private static boolean duplicate(int[] nums) {

        if (nums.length == 0) return false;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 || nums[i] > nums.length - 1) {
                return false;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    a = nums[i];
                    return true;
                }
                int temp = nums[i];
                nums[i] = nums[nums[i]];
                nums[nums[i]] = temp;
            }
        }
        return false;
    }

}
