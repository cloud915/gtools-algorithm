package com.gtools.algorithm.point2offer;

import com.gtools.algorithm.link.Node;

/**
 * @Description
 * @Author ghy
 * @Date 2020/2/15 23:24
 */
public class No13 {
    // 输入一个链表，输出该链表中倒数第k个结点。
    // 思路：
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        // 将fast移动到正数第k个位置
        while (k-- > 1) {
            if (fast.next != null) {
                fast = fast.next;
            } else {
                return null;
            }
        }
        // 再同时移动fast和slow，当fast达到链表尾部时，slow就在倒数k的位置
        // 相像一个时间窗口整体移动，fast和slow之间相差k，当fast到达tail时，slow就在-k位置
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public static class ListNode extends Node {
        public ListNode next;

        public ListNode(Integer val) {
            super(val);
        }

    }

}
