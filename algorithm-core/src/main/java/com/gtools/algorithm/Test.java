package com.gtools.algorithm;

import java.util.List;

public class Test {
    public static void main(String[] args) {

        /*int num = Integer.MAX_VALUE;
        long reNum=reverse(num);
        System.out.println(reNum);*/

      Integer res=  Math.addExact(Integer.MAX_VALUE,Integer.MAX_VALUE);
        System.out.println(res);

    }

    private static long reverse(long num) {
        if(num==0){
            return 0;
        }
        if(num>0){
            return reverseNum(num);
        }else{
            return 0-reverseNum(Math.abs(num));
        }
    }

    private static long reverseNum(long abs) {
        long result=0;
        while(true){
            long n=abs%10;//取出最后一个数
            result=result*10+n;
            abs = abs/10;//降位
            if(abs==0){
                return result;
            }
        }
    }

    /*public void func(List<String> aa){

    }

    public void func(List<Integer> aa){

    }*/



}
