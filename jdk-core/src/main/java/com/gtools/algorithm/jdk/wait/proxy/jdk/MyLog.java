package com.gtools.algorithm.jdk.wait.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description
 * @Author ghy
 * @Date 2019/11/28 15:40
 */
public class MyLog implements InvocationHandler {
    private Object o;

    public MyLog(Object o) {
        this.o = o;
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(Object.class.getClassLoader(), Object.class.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before invoke it.");
        Object result = method.invoke(o, args);
        System.out.println("after invoke it.");
        return result;
    }
}
