package com.gtools.algorithm.jdk.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description
 * @Author ghy
 * @Date 2020/4/22 15:35
 */
public class PatternTest {

    public static void main(String[] args) {
        /*Pattern pattern=Pattern.compile("[abc]]");
        Matcher matcher=pattern.matcher("hello abc");
        System.out.println(matcher.matches());

        System.out.println(Pattern.matches("\\w+","hello abc"));
        System.out.println(Pattern.matches("\\w+","hellosabc"));*/

        /*Pattern pattern=Pattern.compile("\\w+");
        Matcher matcher=pattern.matcher("hello abc bbc cbc ccc");
        while (matcher.find()){
            System.out.println(matcher.group());
        }*/

       /* Pattern pattern=Pattern.compile("\\d+(\\w+)");
        Matcher matcher=pattern.matcher("hello123gg abc bbc cbc ccc");
        System.out.println(matcher.groupCount());
        while (matcher.find()) {
            System.out.println(matcher.group());
        }*/

       /*String input="hello abc BBc CCb ccc";
       Matcher matcher=Pattern.compile("[A-Z][A-Z]\\w").matcher(input);
       while(matcher.find()) {
           System.out.println(input.charAt(matcher.start()));
           System.out.println(input.charAt(matcher.end() - 1));
           System.out.println();
       }*/
        Matcher matcher=Pattern.compile("a").matcher("aaaab");
        System.out.println(matcher.matches());// 匹配全串
        System.out.println(matcher.lookingAt());// 匹配子串

    }
}
