package com.gtools.algorithm.jdk.juc.forkjoin;

import java.util.concurrent.ForkJoinPool;

public class ForkJoinTest {
    public static void main(String[] args) {
        //ForkJoinPool pool=ForkJoinPool.commonPool();
        System.out.println(Runtime.getRuntime().availableProcessors());
        ForkJoinPool pool2 = new ForkJoinPool(Runtime.getRuntime().availableProcessors() * 2);


        //CustomRecursiveAction cra = new CustomRecursiveAction("hello world,today is beautiful.");
        //pool2.invoke(cra);

        int[] intArray = {12, 12, 13, 14, 15,12, 12, 13, 14, 15,12, 12, 13, 14, 15};
        CustomRecursiveTask crt = new CustomRecursiveTask(intArray);
        int result = pool2.invoke(crt);
        System.out.println(result);
    }
}
