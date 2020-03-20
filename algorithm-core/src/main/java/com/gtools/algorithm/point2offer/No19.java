package com.gtools.algorithm.point2offer;

import java.util.Stack;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description
 * @Author ghy
 * @Date 2020/3/4 14:16
 */
public class No19 {
    /* 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
       注意：保证测试中不会当栈为空的时候，对栈调用pop()或者min()或者top()方法。
    * */
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();
    private Integer min = Integer.MAX_VALUE;

    public void push(int node) {
        stack.push(node);
        if (node < min) {
            minStack.push(min);
            min = node;
        }
    }

    public void pop() {
        if (stack.size() > 0) {
            int val = stack.pop();
            if (val == min) {
                min = minStack.pop();
            }
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min;
    }
}
