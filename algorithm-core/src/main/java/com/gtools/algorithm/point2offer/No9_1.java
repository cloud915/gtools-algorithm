package com.gtools.algorithm.point2offer;

/**
 * @Description
 * @Author ghy
 * @Date 2020/2/13 17:45
 */
public class No9_1 {
    // 9.1.现在要求输入一个整数n，请你输出斐波那契数列的第n项。n<=39


    // 思路：递归的效率低，使用循环方式。

    // 什么是斐波那契数列 1、1、2、3、5、8、13、21
    // ……在数学上，斐波纳契数列以如下被以递归的方法定义：F0=0，F1=1，Fn=F(n-1)+F(n-2)（n>=2，n∈N*）。

    public long fibonacci1(int n) {
        if (n <= 2) {
            return 1;
        } else {
            return fibonacci1(n - 1) + fibonacci1(n - 2);
        }
    }

    public static void main(String[] args) {
        No9_1 no=new No9_1();
        System.out.println(no.fibonacci(4));
    }

    // 回到题目，使用循环方式实现
    public long fibonacci(int n) {
        int result = 0;
        int preOne = 1; // 离着第三个值 只有一步的值==前一个
        int preTwo = 0; // 离着第三个值 只有二步的值==前二个
        if (n == 0) {
            return preTwo;
        }
        if (n == 1) {
            return preOne;
        }
        for (int i = 2; i <= n; i++) {
            result = preOne + preTwo; // 下一个值，是前两个值的和
            preTwo = preOne;// 前进一个值
            preOne = result;// 前进一个值
        }
        return result;
    }
}
