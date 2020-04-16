package com.gtools.algorithm.jdk.juc;

import java.util.concurrent.Semaphore;

/**
 * @Description
 * @Author ghy
 * @Date 2020/4/14 16:12
 */
public class SemaphoreTest {
    public static void main(String[] args) throws InterruptedException {

        Semaphore semaphore=new Semaphore(2);
        semaphore.acquire();
        int i=0;
        while (i<100){
            System.out.println("a");
            i++;
        }
        semaphore.release();

    }
}
