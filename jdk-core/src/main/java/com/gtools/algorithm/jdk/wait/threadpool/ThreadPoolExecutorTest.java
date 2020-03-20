package com.gtools.algorithm.jdk.wait.threadpool;

import java.time.LocalDateTime;
import java.util.concurrent.*;

/**
 * @Description
 * @Author ghy
 * @Date 2019/12/7 11:14
 */
public class ThreadPoolExecutorTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<String> f1 = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(1000);
                return LocalDateTime.now().toString();
            }
        });
        Future<String> f2 = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(3000);
                return LocalDateTime.now().toString();
            }
        });

        executorService.shutdown();

        System.out.println(f1.get());
        System.out.println(f2.get());

    }
}
