package com.gtools.algorithm.point2offer;

/**
 * @Description
 * @Author ghy
 * @Date 2020/5/26 18:18
 */
public class No44 {
    // 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出
    //
    //思路：拼接 或 反转三次字符串

    public static String LeftRotateString(String str,int n) {
        if (str == null || str.length() == 0)
            return str;
        String s1 = reverse(str.substring(0,n));
        String s2 = reverse(str.substring(n,str.length()));
        return reverse(s2)+reverse(s1);
    }

    public static String reverse(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0 ; i--) {
            sb.append(str.charAt(i));
        }
        return String.valueOf(sb);
    }
}
