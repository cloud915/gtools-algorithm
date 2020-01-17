package com.gtools.algorithm.jdk.gof.single;

/**
 * @Description 线程安全的懒汉模式
 * @Author ghy
 * @Date 2020/1/17 10:32
 */
public class Three {
    private static Three instance;

    private Three() {
    }

    public static synchronized Three getInstance() {
        if (instance == null) {
            instance = new Three();
        }
        return instance;
    }


}
