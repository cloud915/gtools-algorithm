package com.gtools.algorithm.point2offer;

/**
 * @Description
 * @Author ghy
 * @Date 2020/5/26 15:17
 */
public class No32 {
    // 从1到非负整数n中1出现的次数

    // 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
    // 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
    // ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
    //
    // 思路：若百位上数字为0，百位上可能出现1的次数由更高位决定；
    // 若百位上数字为1，百位上可能出现1的次数不仅受更高位影响还受低位影响；
    // 若百位上数字大于1，则百位上出现1的情况仅由更高位决定

    public static void main(String[] args) {
        System.out.println(CountOne2(2000));
    }

    public static long CountOne2(long n) {
        long count = 0; // 1的个数
        long i = 1;  // 当前位
        long current = 0,after = 0,before = 0;

        while((n / i) != 0) {
            before = n / (i * 10); // 高位
            current = (n / i) % 10; // 当前位
            after = n - (n / i) * i;  // 低位

            if (current == 0)
                //如果为0,出现1的次数由高位决定,等于高位数字 * 当前位数
                count = count + before * i;
            else if(current == 1)
                //如果为1,出现1的次数由高位和低位决定,高位*当前位+低位+1
                count = count + before * i + after + 1;
            else if (current > 1)
                // 如果大于1,出现1的次数由高位决定,（高位数字+1）* 当前位数
                count = count + (before + 1) * i;
            //前移一位
            i = i * 10;
        }
        return count;
    }


}
