package com.gtools.algorithm.point2offer;

import java.util.ArrayList;

/**
 * @Description
 * @Author ghy
 * @Date 2020/5/27 11:49
 */
public class No65 {
    // 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值
    //
    //思路：两个for循环，第一个for循环滑动窗口，第二个for循环滑动窗口中的值，寻找最大值。还可以使用时间复杂度更低的双端队列求解。

    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> list = new ArrayList<>();
        if (num == null || size < 1 || num.length < size)
            return list;
        int length = num.length - size + 1;

        for (int i = 0; i < length; i++) {
            int current = size + i;
            int max = num[i];
            for (int j = i; j < current; j++) {
                if (max < num[j]) {
                    max = num[j];
                }
            }
            list.add(max);
        }
        return list;
    }

}
