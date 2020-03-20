package com.gtools.algorithm.jdk.wait.proxy;


import com.gtools.algorithm.jdk.wait.proxy.jdk.MyLog;
import com.gtools.algorithm.jdk.wait.proxy.jdk.Person;
import com.gtools.algorithm.jdk.wait.proxy.jdk.Student;

/**
 * @Description
 * @Author ghy
 * @Date 2019/11/28 15:40
 */
public class JdkProxyTest {
    public static void main(String[] args) {
        MyLog myLog = new MyLog(new Student());
        Person person = (Person) myLog.getProxy();
        person.sayHi("fred");
        person.sayGoodbye("fred");
    }
}
