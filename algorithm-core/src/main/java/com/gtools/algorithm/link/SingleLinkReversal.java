package com.gtools.algorithm.link;

import java.util.Stack;

/**
 * @Description
 * @Author ghy
 * @Date 2020/1/9 14:42
 */
public class SingleLinkReversal {

    public static void main(String[] args) {
        Node head = Node.createLink(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Node.print(head);

        Node newHead = reversal1(head);
        Node.print(newHead);
        Node newHead2 = reversal3(newHead);
        Node.print(newHead2);
        Stack<Integer> stack=new Stack<>();
        int a=1;
        stack.push(a);

    }

    /**
     * 递归
     *
     * @param head
     * @return
     */
    private static Node reversal1(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node next = head.next;
        Node reNode = reversal1(head.next);
        next.next = head;
        head.next = null;
        return reNode;
    }

    /**
     * 循环
     *
     * @param head
     * @return
     */
    private static Node reversal2(Node head) {
        Node cur = head;
        Node next = head.next;
        Node temp;
        while (next != null) {
            temp = next.next;
            next.next = cur;

            cur = next;
            next = temp;
        }
        head.next = null;
        return cur;
    }
    private static Node reversal3(Node head) {
        Node cur=head;
        Node next=head.next;
        Node tmp;
        while(next!=null){
            tmp=next.next;
            next.next=cur;

            cur=next;
            next=tmp;
        }
        head.next=null;
        return cur;
    }
}
