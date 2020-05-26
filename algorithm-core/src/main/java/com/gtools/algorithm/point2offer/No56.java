package com.gtools.algorithm.point2offer;

import com.gtools.algorithm.link.Node;

/**
 * @Description
 * @Author ghy
 * @Date 2020/5/26 19:13
 */
public class No56 {
    // 一个链表中包含环，请找出该链表的环的入口结点。
    // 思路：定义快慢两个指针，相遇后（环中相汇点）将快指针指向pHead 然后一起走，每次往后挪一位，相遇的节点即为所求。详细分析：相遇即p1==p2时，p2所经过节点数为2x,p1所经过节点数为x,设环中有n个节点,p2比p1多走一圈有2x=n+x; n=x;可以看出p1实际走了一个环的步数，再让p2指向链表头部，p1位置不变，p1,p2每次走一步直到p1==p2; 此时p1指向环的入口。

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null)
            return null;
        ListNode slow = pHead;
        ListNode fast = pHead;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                fast = pHead;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                if (fast == slow)
                    return slow;
            }
        }
        return null;
    }


    public static class ListNode extends Node {
        public ListNode next;

        public ListNode(Integer val) {
            super(val);
        }

    }
}
