package com.gtools.algorithm.jdk.list;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @Description
 * @Author ghy
 * @Date 2020/5/22 11:49
 */
public class QueueTest {
    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> queue=new ArrayBlockingQueue<Integer>(10);
        LinkedBlockingDeque<Integer> lq=new LinkedBlockingDeque<>();
        lq.add(1);
        lq.add(2);
        lq.add(3);
        lq.add(4);
        ; // 获取首个，但不删除
        System.out.println(lq.peek() + " : lq.peek()后 : " + lq.toString());
        System.out.println(lq.pop() + " : lq.pop()后 : " + lq.toString());
        System.out.println(lq.poll() + " : lq.poll()后 : " + lq.toString());
        System.out.println(lq.getFirst() + " : lq.getFirst()后 : " + lq.toString());
        /*lq.poll();// 从头部拿出数据
        System.out.println(lq.toString());
        lq.pop();// 从头部拿出数据
        System.out.println(lq.toString());
        lq.getFirst(); // 获取首个，但不删除
        System.out.println(lq.toString());*/
    }
}
