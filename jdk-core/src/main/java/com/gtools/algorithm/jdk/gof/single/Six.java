package com.gtools.algorithm.jdk.gof.single;

/**
 * @Description
 * @Author ghy
 * @Date 2020/1/17 10:37
 */
public class Six {
    // 添加volatile，目的是在并发条件下，两个线程间的可见性
    private static volatile Six instance;

    private Six() {
    }

    /**
     * 在并发时，双重校验锁法会有怎样的情景：
     * STEP 1. 线程A访问getInstance()方法，因为单例还没有实例化，所以进入了锁定块。
     * STEP 2. 线程B访问getInstance()方法，因为单例还没有实例化，得以访问接下来代码块，而接下来代码块已经被线程1锁定。
     * STEP 3. 线程A进入下一判断，因为单例还没有实例化，所以进行单例实例化，成功实例化后退出代码块，解除锁定。
     * STEP 4. 线程B进入接下来代码块，锁定线程，进入下一判断，因为已经实例化，退出代码块，解除锁定。
     * STEP 5. 线程A初始化并获取到了单例实例并返回，线程B获取了在线程A中初始化的单例。
     * 理论上双重校验锁法是线程安全的，并且，这种方法实现了lazyloading。
     *
     * @return
     */
    public static Six getInstance() {
        if (instance == null) {
            synchronized (Six.class) {
                if (instance == null) {
                    // new 不是原子化操作，因此instance要用volatile修饰,防止指令重排
                    instance = new Six();
                }
            }
        }
        return instance;
    }
}
