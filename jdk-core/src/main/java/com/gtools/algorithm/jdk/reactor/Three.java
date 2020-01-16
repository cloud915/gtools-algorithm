package com.gtools.algorithm.jdk.reactor;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @Description 多线程模式下的Reactor，将Handler这个事件处理器模块，多线程化
 * @Author ghy
 * @Date 2020/1/15 11:09
 */
public class Three {

    /**
     * 以下只是示例代码，含义解析：
     *
     * 创建一个线程池，在进行read和write过程时，创建线程，放入线程池
     */

    /*static class Handler implements Runnable {
        static Executor pool = Executors.newCachedThreadPool();
        static final int PROCESSING=3;

        synchronized void read() { // ...
            socket.read(input);
            if (inputIsComplete()) {
                state = PROCESSING; // 状态迁移
                pool.execute(new Processer()); //使用线程pool异步执行
            }
        }

        synchronized void processAndHandOff() {
            process(); // 处理逻辑
            state = SENDING; // or rebind attachment  // 状态迁移
            sk.interest(SelectionKey.OP_WRITE); //process完,开始等待write事件
        }

        class Processer implements Runnable {
            public void run() { processAndHandOff(); }
        }
    }*/


    /**
     * 继续改进：对于多个CPU的机器，为充分利用系统资源，将Reactor拆分为两部分
     * 一个mainReactor，负责监听连接，accept连接给subReactor处理。
     * mainReactor的连接，需要三次握手才能建立，这个过程是要耗时间和资源，单独分一个Reactor来处理，可以提高性能（减少阻塞）。
     */
}
