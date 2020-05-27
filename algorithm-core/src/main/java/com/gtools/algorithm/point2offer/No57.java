package com.gtools.algorithm.point2offer;

import com.gtools.algorithm.link.Node;

/**
 * @Description
 * @Author ghy
 * @Date 2020/5/26 19:16
 */
public class No57 {
    // 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
    // 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) return null;
        ListNode first = new ListNode(-1);
        first.next = pHead;
        ListNode cur = pHead;
        ListNode pre = first;

        while (cur != null && cur.next != null) {
            if (cur.val.equals(cur.next.val)) {
                int val = cur.val;
                // 向后重复查找
                while (cur != null && cur.val == val) {
                    cur = cur.next;
                }
                pre.next = cur;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return first.next;
    }


    public static class ListNode extends Node {
        public ListNode next;

        public ListNode(Integer val) {
            super(val);
        }

    }
}
