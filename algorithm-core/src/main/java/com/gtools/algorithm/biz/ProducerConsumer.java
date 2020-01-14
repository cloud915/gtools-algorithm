package com.gtools.algorithm.biz;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description
 * @Author ghy
 * @Date 2020/1/14 16:22
 */
public class ProducerConsumer {
    private static volatile List<String> list = new LinkedList<String>();
    private static ReentrantLock lock = new ReentrantLock();
    private static Condition isEmpty = lock.newCondition();
    private static Condition isFull = lock.newCondition();

    public static void main(String[] args) {
        /*Thread producer = new Thread(new Producer(lock));
        Thread consumer1 = new Thread(new Consumer(lock));
        Thread consumer2 = new Thread(new Consumer(lock));*/
        Thread producer = new Thread(new Producer());
        Thread consumer1 = new Thread(new Consumer());
        Thread consumer2 = new Thread(new Consumer());
        producer.setName("producer-1");
        consumer1.setName("consumer-1");
        consumer2.setName("consumer-2");

        consumer1.start();
        consumer2.start();
        producer.start();
    }

    public static class Producer implements Runnable {

       /* public Lock lock;

        public Producer(Lock lock) {
            this.lock = lock;
        }*/

        public void run() {
            while (true) {
                lock.lock();
                try {
                    String time = String.valueOf(System.currentTimeMillis());
                    list.add(time);
                    System.out.println(Thread.currentThread().getName() + " add to list:" + time);
                    if (list.size() >= 20) {
                        isFull.await();
                    } else {
                        isEmpty.signalAll();
                    }
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public static class Consumer implements Runnable {

       /* public Lock lock;

        public Consumer(Lock lock) {
            this.lock = lock;
        }*/

        public void run() {
            while (true) {
                lock.lock();
                try {
                    if (list.size() > 0) {
                        System.out.println(Thread.currentThread().getName() + " remove to list:" + list.remove(0));
                    }else{
                        isEmpty.await();
                    }
                    if (list.size() < 20) {
                        isFull.signalAll();
                    }
                    Thread.sleep(150);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
