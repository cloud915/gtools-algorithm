package com.gtools.algorithm.point2offer;

import java.util.Arrays;

/**
 * @Description
 * @Author ghy
 * @Date 2020/4/24 14:32
 */
public class No22 {
    // 输入一个非空整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
    // 如果是则输出Yes,否则输出No。
    // 假设输入的数组的任意两个数字都互不相同。
    public boolean VerifySquenceOfBST(int[] sequence) {

        int rstart = 0;
        int length = sequence.length;
        for (int i = 0; i < length - 1; i++) {
            if (sequence[i] < sequence[length - 1]) { // 二叉搜索树的 最右节点是最大值
                rstart++;
            }
        }

        if (rstart == 0) {
            VerifySquenceOfBST(Arrays.copyOfRange(sequence, 0, length - 1));
        } else {
            for (int i = rstart; i < length - 1; i++) {// 找到最大值后，再继续遍历数组由rstart开始的剩余部分
                if (sequence[i] <= sequence[length - 1]) { // 如果发现某个值，会不大于数组最后一个值
                    return false;// 说明不满足，因为数组的最大值，应该是倒数第二个节点，最后一个是上一级的节点
                }
            }
            VerifySquenceOfBST(Arrays.copyOfRange(sequence, 0, rstart));
            VerifySquenceOfBST(Arrays.copyOfRange(sequence, rstart, length - 1));
        }

        return true;
    }
}
