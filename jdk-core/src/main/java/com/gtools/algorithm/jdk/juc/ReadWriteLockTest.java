package com.gtools.algorithm.jdk.juc;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Description
 * @Author ghy
 * @Date 2019/12/25 11:09
 */
public class ReadWriteLockTest {
    private static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private static Lock readLock = lock.readLock();
    private static Lock writeLock = lock.writeLock();
    private static Integer data = 0;

    public static void main(String[] args) {
        Thread read1 = new Thread(new ReadObj());
        Thread read2 = new Thread(new ReadObj());
        Thread write = new Thread(new WriteObj());

        read1.start();
        read2.start();
        write.start();

    }

    public static class ReadObj implements Runnable {
        Random random = new Random();
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(random.nextInt(10)*100);
                    readLock.lock();
                    System.out.println(Thread.currentThread().getName() + " read data value is :" + data);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    readLock.unlock();
                }
            }
        }
    }

    public static class WriteObj implements Runnable {
        Random random = new Random();

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(random.nextInt(10)*100);
                    writeLock.lock();
                    data = random.nextInt(100);
                    System.out.println("write data value is :" + data);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    writeLock.unlock();
                }
            }
        }
    }
}
