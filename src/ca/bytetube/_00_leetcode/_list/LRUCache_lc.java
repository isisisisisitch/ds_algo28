package ca.bytetube._00_leetcode._list;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/lru-cache/
 *
 * @author dall.
 */
public class LRUCache_lc {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

    }
    HashMap<Integer, Node> cache;
    Node head, tail;
    int capacity;

    public LRUCache_lc(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new Node(0, 0);//dummy node
        tail = new Node(0, 0);//dummy node
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        Node node = cache.get(key);
        remove(node);
        addToHead(node);
        return node.value;
    }

    private void addToHead(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            remove(node);
            addToHead(node);
        } else {
            if (cache.size() >= capacity) {
                Node lru = tail.prev;
                remove(lru);
                cache.remove(lru.key);
            }
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
        }
    }

    private static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
