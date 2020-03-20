package com.gtools.algorithm.jdk.juc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Author ghy
 * @Date 2019/12/9 16:33
 */
public class DelayQueueTest {


    public static class DelayEvent implements Delayed {
        private Date startDate;

        public DelayEvent(Date startDate) {
            this.startDate = startDate;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            Date now = new Date();
            long diff = startDate.getTime() - now.getTime();
            return unit.convert(diff, TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            long result = this.getDelay(TimeUnit.NANOSECONDS) - o.getDelay(TimeUnit.NANOSECONDS);
            return result == 0 ? 0 : (result < 0 ? -1 : 1);
        }
    }

    public static class DelayTask implements Runnable {
        private int id;
        private DelayQueue<DelayEvent> queue;

        public DelayTask(int id, DelayQueue<DelayEvent> queue) {
            super();
            this.id = id;
            this.queue = queue;
        }

        @Override
        public void run() {
            Date now = new Date();
            Date delay = new Date();
            delay.setTime(now.getTime() + id * 1000);
            System.out.println("Thread " + id + " " + delay);
            for (int i = 0; i < 100; i++) {
                DelayEvent delayEvent = new DelayEvent(delay);
                queue.add(delayEvent);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        DelayQueue<DelayEvent> queue = new DelayQueue<>();
        List<Thread> threads = new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {
            DelayTask task = new DelayTask(i + 1, queue);
            threads.add(new Thread(task));
        }
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }

        do {

            int counter = 0;
            DelayEvent delayEvent;
            do {
                delayEvent = queue.poll();
                if (delayEvent != null) {
                    counter++;
                }

            } while (delayEvent != null);
            System.out.println("At " + new Date() + " you have read " + counter);
            TimeUnit.MILLISECONDS.sleep(500);
        } while (queue.size() > 0);
    }
}
