package com.gtools.algorithm.point2offer;

/**
 * @Description
 * @Author ghy
 * @Date 2020/2/13 18:55
 */
public class No11 {
    /*
    给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
    保证base和exponent不同时为0
     */
    /*public double Power(double base, int exponent) {
        double result=base;
        if(exponent>0){
            while(--exponent!=0){
                result=base*result;
            }
            return result;
        }else{
            while(++exponent!=0){
                result=base*result;
            }
            return result;
        }
    }*/
    public static void main(String[] args) {
        No11 no = new No11();
        System.out.printf("" + no.Power(2, -2));
    }

    public double Power(double base, int exponent) {
        double res = 0;
        if (base == 0) return 0;
        if (exponent == 0) return 1;
        if (exponent > 0) {
            res = mutiplay(base, exponent);
        } else {
            res = mutiplay(1 / base, -exponent);
        }
        return res;
    }

    public double mutiplay(double base, int e) {
        double sum = base;
        while (--e != 0) {
            sum = base * sum;
        }
        return sum;
    }

}
