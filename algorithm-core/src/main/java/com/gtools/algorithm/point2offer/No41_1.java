package com.gtools.algorithm.point2offer;

import java.util.ArrayList;

/**
 * @Description
 * @Author ghy
 * @Date 2020/5/26 17:25
 */
public class No41_1 {
    // 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
    // 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
    // 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
    //
    // 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
    //输出描述:
    //输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序

    //
    //思路：定义两个指针，分别递增，寻找和为s的序列。
    // 9,10,11,12,13,14,15,16
    // 18,19,20,21,22

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        if (sum < 3)
            return arrayList;
        int small = 1;
        int big = 2;
        while (small < (sum + 1) / 2) {
            int s = 0;
            for (int i = small; i <= big; i++) {
                s += i;
            }
            if (s == sum) {
                for (int i = small; i <= big; i++) {
                    list.add(i);
                }
                arrayList.add(new ArrayList<>(list));
                list.clear();
                small++;
            } else {
                if (s > sum) {
                    small++;
                } else {
                    big++;
                }
            }
        }
        return arrayList;
    }
}
