package com.gtools.algorithm.jdk.juc;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Description
 * @Author ghy
 * @Date 2019/12/9 15:50
 */
public class LinkedTest {
    public static void main(String[] args) {
        LinkedBlockingQueue<String> lbq=new LinkedBlockingQueue<>();
        lbq.add("a"); // 最终调用的offer("a")
        lbq.offer("c"); // 最终调用的enqueue(node);
        try {
            lbq.put("b"); // 可中断,最终调用的enqueue(node);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            lbq.take(); // dequeue(); 生产者消费者模式，实现阻塞获取
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lbq.poll(); // dequeue(); 与 put() 组成生产者消费者模型
        lbq.peek();// 读取头节点，但不移除，如果队列空，则返回null

        ConcurrentLinkedQueue<String> clq=new ConcurrentLinkedQueue<>();
        clq.add("a");  // 尾插法，cas
        clq.offer("c"); // 尾插法，cas
        clq.poll();
        clq.peek();

    }
}
