package com.gtools.algorithm.jdk.wait;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description
 * @Author ghy
 * @Date 2019/12/18 18:30
 */
public class PringABC {
    private static volatile Lock lock = new ReentrantLock();
    private static Condition a = lock.newCondition();
    private static Condition b = lock.newCondition();
    private static Condition c = lock.newCondition();

    public static void main(String[] args) {
        Thread ta = new Thread(new A(lock));
        Thread tb = new Thread(new B(lock));
        Thread tc = new Thread(new C(lock));


        tb.start();
        ta.start();
        tc.start();

    }

    public static class A implements Runnable {

        private Lock lock;

        public A(Lock lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            try {
                lock.lock();
                while (true) {
                    a.await();
                    System.out.print("A ");
                    b.signal();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static class B implements Runnable {

        private Lock lock;

        public B(Lock lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            try {
                lock.lock();
                while (true) {
                    b.await();
                    System.out.print("B ");
                    c.signal();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static class C implements Runnable {

        private Lock lock;

        public C(Lock lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            try {
                lock.lock();
                while (true) {
                    a.signal();
                    c.await();
                    System.out.print("C ");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
