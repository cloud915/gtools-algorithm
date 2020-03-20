package com.gtools.algorithm.point2offer;

/**
 * @Description
 * @Author ghy
 * @Date 2020/2/13 16:24
 */
public class No3 {
    /*
     * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     */
    // 思路：从右上角或左下角开始找，逐行删除，或者用二分法查找

    public static void main(String[] args) {
        int[][] nums = {
                {1, 2, 3},
                {2, 13, 24},
                {13, 14, 25}
        };
        int num = 14;
        System.out.println(find(nums, num));
    }

    private static boolean find(int[][] array, int target) {
        if (array == null) return false;
        int row = 0;
        int column = array[0].length - 1;// 右上角

        while (row < array.length && column >= 0) {
            if (array[row][column] == target)
                return true;

            if (array[row][column] < target) {
                row++;
            } else {
                column--;
            }
        }
        return false;
    }

}
