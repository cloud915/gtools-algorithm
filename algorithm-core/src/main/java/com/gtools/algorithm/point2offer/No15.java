package com.gtools.algorithm.point2offer;

import com.gtools.algorithm.link.Node;

/**
 * @Description
 * @Author ghy
 * @Date 2020/2/16 0:02
 */
public class No15 {
    // 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
    public static void main(String[] args) {
        Node list1 = Node.createLink(1, 3, 5);
        Node list2 = Node.createLink(2, 4, 6, 8, 10);
        No15 no = new No15();
        Node res = no.Merge(list1, list2);
        Node.print(res);

    }

    public Node Merge(Node list1, Node list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        Node result = new Node(-1);
        Node head = result;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                result.next = new Node(list1.val);
                list1 = list1.next;
            } else {
                result.next = new Node(list2.val);
                list2 = list2.next;
            }
            result = result.next;
        }
        if (list1 != null) {
            result.next = list1;
        }
        if (list2 != null) {
            result.next = list2;
        }

        return head.next;
    }
}
