package com.gtools.algorithm.jdk.gof.single;

/**
 * @Description 懒汉模式
 * @Author ghy
 * @Date 2020/1/17 10:31
 */
public class Two {
    private static Two instance;

    private Two() {
    }

    public static Two getInstance() {
        if (instance == null) {
            instance = new Two();
        }
        return instance;
    }
}
