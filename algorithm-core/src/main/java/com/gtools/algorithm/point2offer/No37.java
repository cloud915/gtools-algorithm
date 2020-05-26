package com.gtools.algorithm.point2offer;

/**
 * @Description
 * @Author ghy
 * @Date 2020/5/26 16:12
 */
public class No37 {
    // 输入两个链表，找出它们的第一个公共结点。
    //
    //思路：先求出链表长度，然后长的链表先走多出的几步，然后两个链表同时向下走去寻找相同的节点，
    // 代码量少的方法需要将两个链表遍历两次，然后从头开始相同的节点。

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        int len1 = 1;
        while (p1 != null) {
            p1 = p1.next;
            len1++;
        }
        int len2 = 1;
        while (p2 != null) {
            p2 = p2.next;
            len2++;
        }
        int diff = len1 - len2;

        p1 = pHead1;
        p2 = pHead2;
        if (diff > 0) {
            for (int i = 0; i < diff; i++) {
                p1 = p1.next;
            }
        } else {
            for (int i = 0; i < Math.abs(diff); i++) {
                p2 = p2.next;
            }
        }

        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;

    }


    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
