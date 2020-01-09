package com.gtools.algorithm.link;

/**
 * @Description
 * @Author ghy
 * @Date 2020/1/9 14:45
 */
public class Node {
    public Node next;
    public Integer val;

    public Node(Integer val) {
        this.val = val;
    }

    public static Node createLink(Integer... vals) {
        Node head = new Node(0);
        Node curr = head;
        for (Integer val : vals) {
            Node node = new Node(val);
            head.next = node;
            head = node;
        }

        return curr.next;
    }

    public static void print(Node head) {
        if (head == null) {
            System.out.println();
            return;
        }
        System.out.print(head.val + " ");
        print(head.next);
    }

    public static void main(String[] args) {
        Node node = createLink(1, 2, 3, 4, 5, 6);
        print(node);
    }
}
