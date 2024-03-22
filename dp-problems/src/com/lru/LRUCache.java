package com.lru;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    private Node head, tail;
    private int capacity;
    private Map<Integer, Node> map;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = null;
        this.tail = null;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }

        deleteNode(node);
        appendLast(node);
        return map.get(key).data;

    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node == null) {
            node = new Node(value, key);
        } else {
            node.data = value;
        }

        if (map.size() == capacity) {
            map.remove(head.key);
            head = head.next;
            head.prev = null;
        }

        if (map.get(key) != null) {
            deleteNode(node); //delete from curr pos, bacause need to add to last for recent
        }

        appendLast(node);

        map.put(key, node);
    }

    private void deleteNode(Node node) {
        if (head == null) return;

        if (node == head) {
            head = head.next;
            head.prev = null;
            return;
        }

        if (tail == node) {
            tail = tail.prev;
            tail.next = null;
            return;
        }

        Node next = node.next;
        Node prev = node.prev;

        prev.next = next;
        next.prev = prev;
    }
    private void appendLast(Node node) {
        if (head == null) {
            head = tail = node;
            return;
        }

        tail.next = node;
        node.prev = tail;
        node.next = null;
        tail = node;

    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 0);
        lruCache.put(2, 2);
        lruCache.get(1);
        lruCache.put(3, 3);
        lruCache.get(2);
        lruCache.put(4, 4);
        lruCache.get(1);
        lruCache.get(3);
        lruCache.get(4);


        //[[2],[1,0],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
    }
}
class Node {
    int data;
    int key;
    Node next;
    Node prev;

    public Node(int data, int key) {
        this.data = data;
        this.key = key;
        this.next = null;
        this.prev = null;
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */