package com.gtools.algorithm.jdk.juc;

import java.util.concurrent.*;

/**
 * @Description
 * @Author ghy
 * @Date 2019/12/9 14:03
 */
public class CyclicBarrierTest {


    public static class CyclicBarrierRunnable implements Runnable {
        private CyclicBarrier cyclicBarrier;

        public CyclicBarrierRunnable(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println("进入线程 " + Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
                this.cyclicBarrier.await(); // 设置等待
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            } finally {
                System.out.println("线程结束 " + Thread.currentThread().getName());
            }
        }
    }

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(20, 20, 30, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(1024));
        CyclicBarrier cyclicBarrier=new CyclicBarrier(20);
        for (int i=0;i<20;i++){
            executor.execute(new CyclicBarrierRunnable(cyclicBarrier));
        }
        //cyclicBarrier.reset(); // 可以重置，然后重复使用
        System.out.println("主线程调用reset");
        executor.shutdown();
    }
}
