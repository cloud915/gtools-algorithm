package com.gtools.algorithm.link;

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
     * @param head
     * @return
     */
    private static Node reversal2(Node head) {
        return null;
    }

}
