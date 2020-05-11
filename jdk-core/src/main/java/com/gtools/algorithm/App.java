package com.gtools.algorithm;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/**
 * @Description
 * @Author ghy
 * @Date 2020/1/9 14:41
 */
public class App {
    public static void main(String[] args) {
        //System.out.println(java.util.concurrent.ThreadLocalRandom.current().nextInt());

        /*Queue<Integer> q = new PriorityQueue<>();
        int i = 10;
        Random random = new Random();
        while (i > 0) {
            q.add(random.nextInt(100));
            i--;
        }
        while (!q.isEmpty()) {
            System.out.println(q.poll());
        }*/

        /*ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 10,
                10, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(10));

        for (int i=0;i<10;i++) {
            Future<Integer> future = executor.submit(() -> {
                // do something...
                return 1;
            });
            // 或者
            executor.execute(() -> {
                // do something...
            });
        }
        executor.shutdown();*/

        //System.out.println(Integer.valueOf("-"));
        //System.out.println(Integer.parseInt("-"));

        //Pattern pattern=Pattern.compile("a|b|c");
        //System.out.println(pattern.matcher("ab").matches());
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(2);
        list.sort(Integer::compareTo);
        System.out.println(Arrays.toString(list.toArray()));

    }
}
