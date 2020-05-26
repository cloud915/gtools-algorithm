package com.gtools.algorithm.biz;

import java.util.HashMap;
import java.util.Map;

/**
 * 基于HashMap和双向链表的实现
 */
public class LRUByHashMap {
    class Node {
        Node pre;
        Node next;
        Integer key;
        Integer val;

        Node() {
        }

        Node(Integer key, Integer val) {
            this.key = key;
            this.val = val;
        }
    }

    Map<Integer, Node> map = new HashMap<>();
    Node head;
    Node tail;
    int cap;

    public LRUByHashMap(int capacity) {
        this.cap = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
    }

    public Integer get(Integer key) {
        Node n = map.get(key);
        if (n != null) {
            n.pre.next = n.next;
            n.next.pre = n.pre;
            move(n);
            return n.val;
        }
        return null;
    }

    public void set(Integer key, Integer val) {
        Node n = map.get(key);
        if (n != null) {
            n.val = val;
            map.put(key, n);
            n.pre.next = n.next;
            n.next.pre = n.pre;
            move(n);
            return;
        }
        if (map.size() == cap) {
            Node tmp = head.next;
            head.next = head.next.next;
            head.next.pre = head;
            map.remove(tmp.key);
        }
        n = new Node(key, val);
        move(n);
        map.put(key, n);
    }

    private void move(Node n) {
        n.next = tail;
        n.pre = tail.pre;
        tail.pre.next = n;
        tail.pre = n;
    }

}
