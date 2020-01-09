package com.gtools.algorithm.link;

/**
 * @Description 查找链表的中点
 * @Author ghy
 * @Date 2020/1/9 17:19
 */
public class FindLinkMiddle {
    public static void main(String[] args) {
        Node head = Node.createLink(1, 2, 3, 4, 5, 6, 7, 8, 9);

        Node one = head;
        Node two = head;
        while (two != null && two.next != null) {
            one = one.next;
            two = two.next.next;
        }
        System.out.println(one.val);
    }
}
