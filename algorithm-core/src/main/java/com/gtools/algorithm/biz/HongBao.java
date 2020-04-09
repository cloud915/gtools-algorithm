package com.gtools.algorithm.biz;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Description
 * @Author ghy
 * @Date 2020/4/9 10:57
 */
public class HongBao {

    public static void main(String[] args) {
       /* System.out.println("".equals("1"));
        switch ("") {
            case "":
                System.out.println("is a '' ");
                break;
            default:
                System.out.println("is default");
                break;
        }*/
        int totalAmount = 100;
        int totalNumber = 10;

        List<Integer> res = hongBao(totalAmount, totalNumber);
        System.out.println(res);
        System.out.println(res.stream().mapToInt(x -> x).sum());
    }

    private static List<Integer> hongBao(int totalAmount, int totalNumber) {
        List<Integer> list = new ArrayList<>();
        if (totalAmount <= 0 || totalNumber <= 0) {
            return list;
        }
        for (int i = totalNumber; i >= 2; i--) {
            int x = (totalAmount << 1) / i;
            int random = ThreadLocalRandom.current().nextInt(1, x);
            list.add(random);
            totalAmount -= random;
        }
        list.add(totalAmount);
        return list;
    }

    private static List<Integer> hongBao2(int totalAmount, int totalNumber) {

        List<Integer> list = new ArrayList<>();
        if (totalAmount <= 0 || totalNumber <= 0) {
            return list;
        }

        Set<Integer> set = new HashSet<>();
        while (set.size() < totalNumber - 1) {
            int random = ThreadLocalRandom.current().nextInt(1, totalAmount);
            set.add(random);
        }
        Integer[] amounts = set.toArray(new Integer[0]);
        Arrays.sort(amounts);
        list.add(amounts[0]);
        for (int i = 1; i < amounts.length; i++) {
            list.add(amounts[i] - amounts[i - 1]);
        }
        list.add(totalAmount - amounts[amounts.length - 1]);
        return list;

    }
}
