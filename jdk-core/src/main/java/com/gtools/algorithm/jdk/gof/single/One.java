package com.gtools.algorithm.jdk.gof.single;

/**
 * @Description 饿汉模式
 * @Author ghy
 * @Date 2020/1/17 10:30
 */
public class One {
    public static final One instance = new One();

    private One() {
    }

    public static One getInstance() {
        return instance;
    }
}
