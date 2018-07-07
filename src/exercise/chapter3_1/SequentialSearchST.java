package exercise.chapter3_1;

import exercise.chapter1_3.Queue;

public class SequentialSearchST<Key, Value> {
    private Node first;
    private int N;

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public Value get(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (x.key.equals(key)) {
                return x.value;
            }
        }
        return null;
    }

    public void delete(Key key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        first = delete(first, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null) {
            return null;
        }
        if (x.key.equals(key)) {
            N--;
            return x.next;
        }
        x.next = delete(x.next, key);
        return x;
    }

    public void put(Key key, Value value) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.value = value;
                return;
            }
        }
        first = new Node(key, value, first);
        N++;
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<>();
        for (Node x = first; x != null; x = x.next) {
            queue.enqueue(x.key);
        }
        return queue;
    }

    private class Node {
        Value value;
        Node next;
        Key key;

        public Node(Key key, Value value, Node next) {
            this.value = value;
            this.next = next;
            this.key = key;
        }
    }
}
