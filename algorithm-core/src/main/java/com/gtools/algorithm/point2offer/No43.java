package com.gtools.algorithm.point2offer;

import com.gtools.algorithm.leetcode.ReserveString;

/**
 * @Description
 * @Author ghy
 * @Date 2020/5/26 17:49
 */
public class No43 {
    // 翻转字符串
    //
    //思路：先将整个字符串翻转，然后将每个单词翻转。
    public static void main(String[] args) {
        String s = ReverseSentence("Hello world 张三 你哈");
        System.out.println(s);

    }

    public static String ReverseSentence(String str) {
        char[] chars = str.toCharArray();
        reverse(chars, 0, chars.length - 1);
        int slow = 0, fast = 0;

        while (fast < chars.length) {
            if (chars[fast] == ' ') {
                reverse(chars, slow, fast - 1);
                slow = fast + 1;
                fast = fast + 2;
            } else {
                if (fast == chars.length - 1) {
                    reverse(chars, slow, fast);
                }
                fast++;
            }
        }
        return new String(chars);
    }

    public static String reverse(char[] array, int begin, int end) {
        for (int i = begin; i < end; i++, end--) {
            array[i] ^= array[end];
            array[end] ^= array[i];
            array[i] ^= array[end];
        }

        return new String(array);
    }
}
