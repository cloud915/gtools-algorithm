package com.gtools.algorithm.point2offer;

/**
 * @Description
 * @Author ghy
 * @Date 2020/2/13 16:33
 */
public class No4 {
    /*
        将一个字符串中的空格替换成“%20”。
        例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     */
    // 思路：从后往前复制，数组长度会增加，或使用StringBuilder、StringBuffer类
    public static void main(String[] args) {
        String str = "We Are Happy";
        System.out.println("before: " + str);

        System.out.println("after: " + replaceSpace(str));
    }

    private static String replaceSpace(String str) {
        if (str == null)
            return null;

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if (String.valueOf(str.charAt(i)).equals(" ")) {
                sb.append("%20");
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();

    }
}
