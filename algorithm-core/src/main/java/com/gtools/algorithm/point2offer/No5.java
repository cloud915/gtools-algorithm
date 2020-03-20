package com.gtools.algorithm.point2offer;

import com.gtools.algorithm.link.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * @Description
 * @Author ghy
 * @Date 2020/2/13 16:37
 */
public class No5 {
    // 5.输入一个链表，从尾到头打印链表每个节点的值。
    public static void main(String[] args) {
        Node node = Node.createLink(1, 2, 3, 4, 5);

        //pringReversal(node);
        No5 no5 = new No5();
        ArrayList<Integer> result = no5.printListFromTailToHead(node);
        System.out.println(result.toString());
    }

    private static void pringReversal(Node node) {
        if (node == null) {
            return;
        }
        pringReversal(node.next);
        System.out.print(node.val + " ");
    }

    public ArrayList<Integer> printListFromTailToHead2(Node node) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        find(node, arrayList);
        return arrayList;
    }

    public void find(Node node, ArrayList<Integer> arrayList) {
        if (node == null) {
            return;
        }
        find(node.next, arrayList);
        arrayList.add(node.val);
    }

    public ArrayList<Integer> printListFromTailToHead(Node listNode) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (listNode == null) return arrayList;

        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.isEmpty()) {
            arrayList.add(stack.pop());
        }
        return arrayList;
    }
}
