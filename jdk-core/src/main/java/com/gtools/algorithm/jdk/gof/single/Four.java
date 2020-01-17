package com.gtools.algorithm.jdk.gof.single;

/**
 * @Description 静态内部类加载
 * 静态内部类不会在单例加载时就加载，而是在调用getInstance()方法时才进行加载
 * 达到了类似懒汉模式的效果，而这种方法又是线程安全的
 * @Author ghy
 * @Date 2020/1/17 10:34
 */
public class Four {
    private static class FourHolder {
        private static Four instance = new Four();
    }

    private Four() {
    }

    public static Four getInstance() {
        return FourHolder.instance;
    }
}
