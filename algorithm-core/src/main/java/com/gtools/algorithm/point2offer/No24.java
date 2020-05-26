package com.gtools.algorithm.point2offer;

/**
 * @Description
 * @Author ghy
 * @Date 2020/5/22 14:16
 */
public class No24 {
    // 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
    // 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
    //思路：先复制链表的next节点，将复制后的节点接在原节点后，然后复制其它的节点，最后取偶数位置的节点（复制后的节点）。

    public RandomListNode clone2(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode head = new RandomListNode(pHead.label);
        RandomListNode temp = head;

        while (pHead.next != null) {
            temp.next = new RandomListNode(pHead.next.label);
            if (pHead.random != null) {
                temp.random = new RandomListNode(pHead.random.label);
            }
            pHead = pHead.next;
            temp = temp.next;
        }
        return head;
    }


}
