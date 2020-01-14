package com.gtools.algorithm.biz;

import java.util.Random;

/**
 * @Description 随机生成1~10000不重复并放入数组
 * @Author ghy
 * @Date 2020/1/14 16:49
 */
public class CreateRandomArray {
    public static void main(String args[]) {
        CreateRandomArray rt = new CreateRandomArray();
        int[] a = new int[100];
        int[] b = new int[100];
        rt.addElement(a);
        rt.showElement(a);
        rt.addRandomElement(a, b);
        rt.showElement(b);
    }


    //该方法把1～100的整数按顺序添加到一个数组中
    public void addElement(int[] arr) {
        for (int i = 0; i < 100; i++) {
            arr[i] = i + 1;
        }
    }

    //该方法把1～100之间的整数从数组a随机地添加到数组b中
    public void addRandomElement(int[] a, int[] b) {
        int max = a.length;
        Random r = new Random();
        for (int i = 0; i < a.length; i++) {
            int index = r.nextInt(max);
            b[i] = a[index];
            a[index] = a[max - 1];//该处的作用是为了避免在数组b中出现重复的整数
            max--;
        }
    }

    //该方法展示出数组中的所有元素
    public void showElement(int[] arr) {
        System.out.println("数组" + arr + "中的元素展示如下：");
        for (int i = 0; i < arr.length; i++) {
            if (i % 10 == 0) {
                System.out.println();
            }
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println();
    }
}
