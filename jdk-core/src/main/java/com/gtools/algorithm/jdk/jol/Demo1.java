package com.gtools.algorithm.jdk.jol;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

/**
 * @Description https://www.cnblogs.com/yuhangwang/p/11267364.html
 * @Author ghy
 * @Date 2020/5/7 17:02
 */
public class Demo1 {
    static Test demoTest;

    public static void main(String[] args) throws InterruptedException {
        demoTest = new Test();

       /* System.out.println(VM.current().details());
        System.out.println(ClassLayout.parseInstance(demoTest).toPrintable());*/

        /*System.out.println("befor hash");
        //没有计算HASHCODE之前的对象头
        System.out.println(ClassLayout.parseInstance(demoTest).toPrintable());

        //JVM 计算的hashcode 转换为16进制
        System.out.println("//计算完hashcode 转为16进制：");
        System.out.println("jvm hashcode------------0x"+Integer.toHexString(demoTest.hashCode()));

        //当计算完hashcode之后，我们可以查看对象头的信息变化
        System.out.println("after hash");
        System.out.println(ClassLayout.parseInstance(demoTest).toPrintable());*/

        // -XX:+UseBiasedLocking -XX:BiasedLockingStartupDelay=0
        // 注意：这块严谨来说，在jdk 1.6之后，关于使用偏向锁和轻量级锁，jvm是有优化的，
        // 在没有禁止偏向锁延迟的情况下，使用的是轻量级锁；禁止偏向锁延迟的话，使用的是偏向锁；

        //睡眠5000ms
        //Thread.sleep(5000);

        System.out.println("befor lock");
        System.out.println(ClassLayout.parseInstance(demoTest).toPrintable());

        //加锁
        sync();

        System.out.println("after lock");
        System.out.println(ClassLayout.parseInstance(demoTest).toPrintable());

        // object head
        // 0 0000 0 00
        //     0   0000     0         00
        // unuserd  gc  biased_lock state

        /**
         |======================================================================================================================|
         |                                                     00000101                                                         |
         |======================================================================================================================|
         |                                  unused:1 |  age:4 | biased_lock:1 | lock:2                                          |
         |======================================================================================================================|
         |                                    0     |   0000  |      1        |     01                                          |
         |======================================================================================================================|
         |                                   未使用 | GC分代年龄|   偏向锁标识    | 对象的状态                                       |
         |======================================================================================================================|
         */


        // STATE,
        // 锁的状态为偏向锁：1 01
        // 轻量级锁对象的状态为  00
        // 重量级锁对象的状态为  10

    }

    public static void sync(){
        synchronized (demoTest){
            System.out.println("lock ing");
            System.out.println(ClassLayout.parseInstance(demoTest).toPrintable());
        }
    }
}
