package com.gtools.algorithm.point2offer;

/**
 * @Description
 * @Author ghy
 * @Date 2020/5/26 18:39
 */
public class No50 {
    // 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
    //输入描述:
    //  输入一个字符串,包括数字字母符号,可以为空
    //输出描述:
    //  如果是合法的数值表达则返回该数字，否则返回0
    //示例1
    //输入
    // 1、 +2147483647
    // 2、 1a33
    //输出
    // 1、 2147483647
    // 2、 0

    // 思路：若为负数，则输出负数，字符0对应48,9对应57，不在范围内则返回false。

    public static void main(String[] args) {
        System.out.println(StrToInt("-2147483649"));
    }

    public static int StrToInt(String str) {
        char[] array = str.toCharArray();
        int result = 0;
        boolean isFu = false;

        for (int i = 0; i < array.length; i++) {
            if (array[i] >= 48 && array[i] <= 57) {
                result *= 10;
                result = result + (array[i] - 48);// 溢出问题考虑：正数溢出、负数溢出  2147483640+8
            } else if (array[i] == '+' && i == 0) {
                continue;
            } else if (array[i] == '-' && i == 0) {
                isFu = true;
                continue;
            } else {
                return 0;
            }
        }
        return isFu ? -1 * result : result;
    }
}
