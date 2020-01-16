package com.gtools.algorithm.sort.other;

/**
 * 队列结构
 *
 * @author Fairy2016
 */
class Queue {
    int data[];
    int front;
    int rear;
}

public class RadixSort {

    public static void main(String[] args) {

        Integer a = null;
        System.out.println(a == null ? "" : String.valueOf(a));
        a = -1;
        System.out.println(a == null ? "" : String.valueOf(a));

        /*int[] arr = {923, 812, 765, 6334, 845, 14, 223, 3, 212};
        sort(arr);
        System.out.println(Arrays.toString(arr));*/
    }

    public static void sort(int[] a) {
        //求最大位数
        int count = getNumberCount(getMax(a));
        //十个队列，分别存储数位数值为0-9的元素
        Queue[] queues = new Queue[10];
        //各队列初始化
        for (int i = 0; i < 10; i++) {
            queues[i] = new Queue();
            queues[i].data = new int[a.length];
            queues[i].front = queues[i].rear = -1;
        }

        int m = 1;//m控制取第几位（从个位开始取直到count）
        while (count > 0) {
            for (int i = 0; i < a.length; i++) {
                int t = a[i] / m % 10;
                //根据数值分配入队
                queues[t].data[++queues[t].rear] = a[i];
            }

            //从队号0-9顺序出队收集元素
            int s = 0;
            for (int j = 0; j < 10; j++) {
                while (queues[j].front != queues[j].rear) {
                    a[s++] = queues[j].data[++queues[j].front];
                }
                queues[j].front = queues[j].rear = -1;
            }
            m *= 10;
            count--;
        }
    }

    /**
     * 求排序元素的最大位数
     *
     * @param t
     * @return
     */
    private static int getNumberCount(int t) {
        int count = 0;
        while (t != 0) {
            count++;
            t /= 10;
        }
        return count;
    }

    /**
     * 筛选出最大元素方便确定位数
     *
     * @param a
     * @return
     */
    public static int getMax(int a[]) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            max = Integer.max(max, a[i]);
        }
        return max;
    }

}
