package com.gtools.algorithm.jdk.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author ghy
 * @Date 2020/4/22 18:40
 */
public class HeapOutOfMemoryErrorTest {
    // -verbose:gc -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=D:\dump.log
    /**
     * java 堆内存溢出
     * <p>
     * VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=D:\dump
     *
     * @author yuhao.wang3
     * @since 2019/11/30 17:09
     */
    public static void main(String[] args) throws InterruptedException {
        // 模拟大容器
        List<Long> list = new ArrayList<>();
        for (long i = 1; i > 0; i++) {
            list.add(i);
            if (i % 100_000 == 0) {
                System.out.println(Thread.currentThread().getName() + "::" + i);
            }
        }
    }
}
