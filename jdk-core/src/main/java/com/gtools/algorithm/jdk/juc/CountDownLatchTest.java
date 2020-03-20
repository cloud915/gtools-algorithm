package com.gtools.algorithm.jdk.juc;

import java.util.concurrent.CountDownLatch;

/**
 * @Description
 * @Author ghy
 * @Date 2019/12/9 10:48
 */
public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch cdt=new CountDownLatch(10);

        System.out.println("This is thread of main.");
        for (int i=0;i<10;i++){
            final  int index=i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("This is sub thread, "+index+" it will be countDown.");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    cdt.countDown();
                }
            }).start();
        }

        cdt.await();
        System.out.println("this is thread of main, stop await.");

    }
}
