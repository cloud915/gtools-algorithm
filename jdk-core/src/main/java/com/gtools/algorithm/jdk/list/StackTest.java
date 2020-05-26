package com.gtools.algorithm.jdk.list;

import java.util.Stack;

/**
 * @Description
 * @Author ghy
 * @Date 2020/5/22 11:57
 */
public class StackTest {
    public static void main(String[] args) {
        Stack<Integer> stack=new Stack<>();
        stack.add(1);
        stack.push(2);
        stack.push(3);
        stack.add(4);
        System.out.println("原始："+stack.toString());
        System.out.println(stack.peek() + " : peek()后 : " + stack.toString());// 获取尾结点，但不删除
        System.out.println(stack.pop() + " : pop()后 : " + stack.toString()); // 从尾部弹出

    }
}
