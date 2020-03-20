package com.gtools.algorithm.jdk.wait.proxy.jdk;

/**
 * @Description
 * @Author ghy
 * @Date 2019/11/28 15:45
 */
public class Student implements Person {

    @Override
    public void sayHi(String name) {
        System.out.println(name + " is say hi.");
    }

    @Override
    public void sayGoodbye(String name) {
        System.out.println(name + " is say goodbye.");
    }
}
