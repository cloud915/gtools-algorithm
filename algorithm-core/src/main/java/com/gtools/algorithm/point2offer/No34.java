package com.gtools.algorithm.point2offer;

/**
 * @Description
 * @Author ghy
 * @Date 2020/5/26 15:41
 */
public class No34 {
    // 求从小到大的第N个丑数。丑数是只包含因子2、3和5的数，习惯上我们把1当做是第一个丑数。
    //
    //思路：乘2或3或5，之后比较取最小值。

    public static void main(String[] args) {
        System.out.println(GetUglyNumber_Solution(100));
    }

    public static int GetUglyNumber_Solution(int index) {
        if (index <= 0)
            return 0;
        int[] arr = new int[index];
        arr[0] = 1;
        int multiply2 = 0;
        int multiply3 = 0;
        int multiply5 = 0;

        for (int i = 1; i < index; i++) {
            int min = Math.min(arr[multiply2] * 2,Math.min(arr[multiply3] * 3,arr[multiply5] * 5));
            arr[i] = min;
            if (arr[multiply2] * 2 == min)
                multiply2++;
            if (arr[multiply3] * 3 == min)
                multiply3++;
            if (arr[multiply5] * 5 == min)
                multiply5++;
        }
        return arr[index - 1];

    }
}
