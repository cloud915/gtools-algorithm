package com.gtools.algorithm.jdk.gof.single;

/**
 * @Description 枚举方法
 *  * 解决了以下三个问题：
 *  * (1)自由序列化。
 *  * (2)保证只有一个实例。
 *  * (3)线程安全。
 * @Author ghy
 * @Date 2020/1/17 10:35
 */
public enum Five {
    INSTANCE;

    public void methodA() {
        System.out.println("something.");
    }


}
