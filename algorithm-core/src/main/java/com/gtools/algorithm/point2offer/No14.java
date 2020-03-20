package com.gtools.algorithm.point2offer;

import com.gtools.algorithm.link.Node;

/**
 * @Description
 * @Author ghy
 * @Date 2020/2/15 23:31
 */
public class No14 {
    // 输入一个链表，反转链表后，输出新链表的表头
    public static void main(String[] args) {
        No14 no = new No14();

        Node listNode = Node.createLink(1, 2, 3, 4, 5);
        Node node = no.ReverseList2(listNode);
        Node.print(node);
    }

    public Node ReverseList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node next = head.next;
        Node reNode = ReverseList(head.next);
        next.next = head;
        head.next = null;

        return reNode;

    }

    public Node ReverseList2(Node head) {
        if (head == null || head.next == null) {
            return head;
        }


        Node cur = head;
        Node next = head.next;
        Node temp = null;
        while (next != null) {
            temp = cur;
            cur = next;

            next = next.next;
            cur.next = temp;
        }
        head.next = null;

        return cur;
    }
}
