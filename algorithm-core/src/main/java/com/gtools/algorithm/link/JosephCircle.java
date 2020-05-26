package com.gtools.algorithm.link;

import java.util.Scanner;

/**
 * @Description 约瑟夫环
 * @Author ghy
 * @Date 2020/5/26 11:30
 */
public class JosephCircle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入总人数N(N>=2)：");
        int n = scanner.nextInt();
        if (n < 2) {
            System.out.println("您好！请确保输入的人数大于等于 2");
            return;
        }

        Node currentNode = buildData(n);
        int count = 0;
        Node beforeNode = null;
        while (currentNode != currentNode.next) {
            count++;
            if (count == 3) {
                beforeNode.next = currentNode.next;
                System.out.println("出环的编号是：" + currentNode.val);
                count = 0;
                currentNode = currentNode.next;
            } else {// 向后移动节点
                beforeNode = currentNode;
                currentNode = currentNode.next;
            }
            // 只剩2个节点，不能再进行出环操作
            if (beforeNode.val.equals(currentNode.next.val)) {
                break;
            }
        }

        // 输出最后留在环中的编号
        System.out.println("最后留在环中的编号是： " + currentNode.val + "," + currentNode.next.val);
    }

    private static Node buildData(int n) {
        // 循环链表的头节点
        Node head = null;
        // 循环链表当前节点的前一个节点
        Node prev = null;
        for (int i = 1; i <= n; i++) {
            Node newNode = new Node(i);
            // 如果是第一个节点
            if (i == 1) {
                head = newNode;
                prev = head;
                // 跳出当前循环，进行下一次循环
                continue;
            }
            // 如果不是第一个节点
            prev.next = newNode;
            prev = newNode;
            // 如果是最后一个节点
            if (i == n) {
                prev.next = head;
            }
        }
        return head;
    }
}
