package com.gtools.algorithm.number;

public class ReverseNmber {
    public static void main(String[] args) {
        System.out.println(reverse(Integer.MAX_VALUE));
        // 负数的处理，在外层
    }
    public static int reverse(int x) {

        int res = 0;
        int of = ((1 << 31) - 1) / 10; // 可能越界的判断
        while (x != 0) {
            if (Math.abs(res) > ((1 << 31) - 1) / 10) return 0;
            System.out.println(res*10+"\t"+x%10 +"\t");
            res = res * 10 + x % 10;
            x /= 10;

        }
        return res;
    }
}
