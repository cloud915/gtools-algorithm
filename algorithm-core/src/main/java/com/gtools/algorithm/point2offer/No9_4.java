package com.gtools.algorithm.point2offer;

/**
 * @Description
 * @Author ghy
 * @Date 2020/2/13 18:06
 */
public class No9_4 {

    // 9.2.一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
    // 思路：2^(n-1)
    public int JumpFloorII(int target) {
        int result = 0;
        if (target == 0) {
            result = 0;
        } else if (target == 1) {
            result = 1;
        } else {
            result = 2 * JumpFloorII(target - 1);
        }

        return result;
    }
}
