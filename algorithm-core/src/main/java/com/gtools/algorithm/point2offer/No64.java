package com.gtools.algorithm.point2offer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Description
 * @Author ghy
 * @Date 2020/5/27 11:47
 */
public class No64 {
    // 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
    //
    //思路：创建优先级队列维护大顶堆和小顶堆两个堆，并且小顶堆的值都大于大顶堆的值，2个堆个数的差值小于等于1，所以当插入个数为奇数时：大顶堆个数就比小顶堆多1，中位数就是大顶堆堆头；当插入个数为偶数时，使大顶堆个数跟小顶堆个数一样，中位数就是 2个堆堆头平均数。也可使用集合类的排序方法。
    int count = 0;
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(16, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    });

    public void Insert(Integer num) {
        count++;
        // 当数据的个数为奇数时，进入大根堆
        if ((count & 1) == 1) {
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        } else {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }
    }

    public Double GetMedian() {
        if (count == 0)
            return null;

        // 当数据个数是奇数时，中位数就是大根堆的顶点
        if ((count & 1) == 1) {
            return Double.valueOf(maxHeap.peek());
        } else {
            return Double.valueOf((minHeap.peek() + maxHeap.peek())) / 2;
        }
    }


}
