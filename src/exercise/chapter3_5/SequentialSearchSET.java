package exercise.chapter3_5;

import exercise.chapter1_3.Queue;

public class SequentialSearchSET<Key> {
    private Node first;
    private int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException();
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return false;
            }
        }
        return true;
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
            size--;
            return x.next;
        }
        x.next = delete(x.next, key);
        return x;
    }

    public void add(Key key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return;
            }
        }
        first = new Node(key, first);
        size++;
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<>();
        for (Node x = first; x != null; x = x.next) {
            queue.enqueue(x.key);
        }
        return queue;
    }

    private class Node {
        Node next;
        Key key;

        public Node(Key key, Node next) {
            this.next = next;
            this.key = key;
        }
    }
}
