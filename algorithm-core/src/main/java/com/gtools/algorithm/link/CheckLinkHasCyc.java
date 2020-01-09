package com.gtools.algorithm.link;

/**
 * @Description 检查链表是否有环
 * @Author ghy
 * @Date 2020/1/9 17:23
 */
public class CheckLinkHasCyc {
    public static void main(String[] args) {
        Node head = Node.createLink(1, 2, 3, 4, 5);
        Node randomNode = Node.findNode(head, 3);
        Node.makeCyc(head, randomNode);

        System.out.println("是否含有环：" + checkCyc(head));
        System.out.println("产生环的位置：" + findCyc(head).val);
    }

    private static boolean checkCyc(Node head) {

        Node one = head;
        Node two = head;

        while (two != null && two.next != null) {
            one = one.next;
            two = two.next.next;
            if (one.val.equals(two.val)) {
                System.out.println("相遇在：" + one.val);
                return true;
            }
        }
        return false;
    }

    private static Node findCyc(Node head) {
        Node one = head;
        Node two = head;

        while (two != null && two.next != null) {
            one = one.next;
            two = two.next.next;
            if (one == two) {
                two = head;
                // 将two退回起点，再次相遇，说明two是one所走距离的2倍
                // 假设链表开头到环接口的距离是y，那么x-y表示slow指针走过的除链表开头y在环中走过的距离，那么slow再走y步，此时fast结点与slow结点相遇，fast == slow ，x-y+y=x = rn，即此时slow指向环的入口。
                while (one != two) {
                    one = one.next;
                    two = two.next;
                }
                return one;
            }
        }
        return head;
    }
}
