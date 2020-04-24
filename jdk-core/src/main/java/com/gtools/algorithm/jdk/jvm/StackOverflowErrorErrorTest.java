package com.gtools.algorithm.jdk.jvm;

/**
 * java 虚拟机栈和本地方法栈内存溢出测试
 * <p>
 * VM Args: -Xss128k
 *
 * @author yuhao.wang3
 * @since 2019/11/30 17:09
 */
public class StackOverflowErrorErrorTest {
    private int stackLength = 0;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        StackOverflowErrorErrorTest sof = new StackOverflowErrorErrorTest();
        try {
            sof.stackLeak();
        } catch (Exception e) {
            System.out.println(sof.stackLength);
            e.printStackTrace();
        }
    }
}
