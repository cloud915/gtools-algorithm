package com.gtools.algorithm.jdk.wait.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Description 线程池与定时任务结合：ScheduledExecutorService
 * @Author ghy
 * @Date 2020/1/6 14:09
 */
public class ScheduledExecutorServiceTest {

    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("run " + System.currentTimeMillis());
            }
        }, 0, 500, TimeUnit.MILLISECONDS);
    }


}
