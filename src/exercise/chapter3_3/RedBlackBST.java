package exercise.chapter3_3;

import exercise.chapter1_3.Queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RedBlackBST<Key extends Comparable<Key>, Value> implements Iterable<Key> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private Node root;

    public RedBlackBST() {

    }

    private int size(Node h) {
        if (h == null) return 0;
        return h.size;
    }

    public int size() {
        return size(root);
    }

    public boolean isEmpty() {
        return root == null;
    }

    private boolean isRed(Node h) {
        if (h == null) return false;
        return h.color;
    }

    private Node rotateLeft(Node h) {
        if (h == null) throw new IllegalArgumentException();
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = x.left.color;
        x.left.color = RED;
        x.size = h.size;
        h.size = 1 + size(h.left) + size(h.right);
        return x;
    }

    private Node rotateRight(Node h) {
        if (h == null) throw new IllegalArgumentException();
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = x.right.color;
        x.right.color = RED;
        x.size = h.size;
        h.size = 1 + size(h.left) + size(h.right);
        return x;
    }

    private Node flipColors(Node h) {
        if (h == null || h.left == null || h.right == null) throw new IllegalArgumentException();
        h.color = !h.color;
        h.left.color = !h.left.color;
        h.right.color = !h.right.color;

        return h;
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
        root.color = BLACK;
    }

    private Node put(Node h, Key key, Value value) {
        if (key == null) throw new IllegalArgumentException();
        if (h == null) return new Node(key, value, 1, RED);

        int comp = key.compareTo(h.key);
        if (comp > 0) h.right = put(h.right, key, value);
        else if (comp < 0) h.left = put(h.left, key, value);
        else h.value = value;

        if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right)) h = flipColors(h);

        h.size = size(h.left) + size(h.right) + 1;
        return h;
    }

    public void deleteMin() {
        if (isEmpty()) throw new NoSuchElementException();
        if (!isRed(root.left) && !isRed(root.right))
            root.color = RED;
        root = deleteMin(root);
        if (!isEmpty()) root.color = BLACK;
    }

    private Node deleteMin(Node h) {
        if (h.left == null) return null;
        if (!isRed(h.left) && !isRed(h.left.left))
            h = moveRedLeft(h);
        h.left = deleteMin(h.left);
        return balance(h);
    }

    private Node moveRedLeft(Node h) {
        flipColors(h);

        if (isRed(h.right.left)) {
            h.right = rotateRight(h.right);
            h = rotateLeft(h);
        }
        return h;
    }

    public void deleteMax() {
        if (isEmpty()) throw new NoSuchElementException();
        if (!isRed(root.left) && !isRed(root.right))
            root.color = RED;
        root = deleteMax(root);
        if (!isEmpty()) root.color = BLACK;
    }

    private Node deleteMax(Node h) {
        if (isRed(h.left))
            h = rotateRight(h);
        if (h.right == null) return null;

        if (!isRed(h.right) && !isRed(h.right.left))
            h = moveRedRight(h);
        h.right = deleteMax(h.right);
        return balance(h);
    }

    private Node moveRedRight(Node h) {
        flipColors(h);
        if (!isRed(h.left.left))
            h = rotateRight(h);
        return h;
    }

    private Node balance(Node h) {
        if (!isRed(h.left) && isRed(h.right)) h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right)) flipColors(h);
        h.size = size(h.left) + size(h.right) + 1;
        return h;
    }

    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException();
        if (isEmpty()) throw new NoSuchElementException();
        if (!isRed(root.left) && !isRed(root.right))
            root.color = RED;
        root = delete(root, key);
        if (!isEmpty()) root.color = BLACK;
    }

    private Node delete(Node h, Key key) {
        if (key.compareTo(h.key) < 0) {
            if (!isRed(h.left) && !isRed(h.left.left))
                h = moveRedLeft(h);
            h.left = delete(h.left, key);
        } else {
            if (isRed(h.left))
                h = rotateRight(h);
            if (key.compareTo(h.key) == 0 && h.right == null)
                return null;
            if (!isRed(h.right) && !isRed(h.right.left))
                h = moveRedRight(h);
            if (key.compareTo(h.key) == 0) {
                h.value = get(h.right, min(h.right).key);
                h.key = min(h.right).key;
                h.right = deleteMin(h.right);
            } else h.right = delete(h.right, key);
        }
        return balance(h);
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node h, Key key) {
        if (key == null) throw new IllegalArgumentException();
        if (h == null) return null;
        int comp = key.compareTo(h.key);
        if (comp > 0) return get(h.right, key);
        else if (comp < 0) return get(h.left, key);
        else return h.value;
    }

    public Key min() {
        return min(root).key;
    }

    private Node min(Node h) {
        if (h == null) throw new NoSuchElementException();
        if (h.left == null) return h;
        return min(h.left);
    }

    public Key max() {
        return max(root).key;
    }

    private Node max(Node h) {
        if (h == null) throw new NoSuchElementException();
        if (h.right == null) return h;
        return max(h.right);
    }

    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    public Iterable<Key> keys(Key low, Key hi) {
        Queue<Key> queue = new Queue<>();
        keys(root, queue, low, hi);
        return queue;
    }

    private void keys(Node x, Queue queue, Key lo, Key hi) {
        if (x == null) return;
        int comlo = lo.compareTo(x.key);
        int comhi = hi.compareTo(x.key);
        if (comlo < 0) keys(x.left, queue, lo, hi);
        if (comlo <= 0 && comhi >= 0) queue.enqueue(x.key);
        if (comhi > 0) keys(x.right, queue, lo, hi);
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public Key ceiling(Key key) {
        if (isEmpty()) throw new NoSuchElementException();
        Node x = ceiling(root, key);
        return x == null ? null : x.key;
    }

    private Node ceiling(Node h, Key key) {
        if (key == null) throw new IllegalArgumentException();
        if (h == null) return null;
        int cmp = key.compareTo(h.key);
        if (cmp > 0) return ceiling(h.right, key);
        else if (cmp == 0) return h;
        else {
            Node t = ceiling(h.left, key);
            return t != null ? t : h;
        }
    }

    public Key floor(Key key) {
        if (isEmpty()) throw new NoSuchElementException();
        Node x = floor(root, key);
        return x == null ? null : x.key;
    }

    private Node floor(Node h, Key key) {
        if (key == null) throw new IllegalArgumentException();
        if (h == null) return null;
        int cmp = key.compareTo(h.key);
        if (cmp < 0) return floor(h.left, key);
        else if (cmp == 0) return h;
        else {
            Node t = floor(h.right, key);
            return t != null ? t : h;
        }
    }

    @Override
    public Iterator<Key> iterator() {
        return keys().iterator();
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("key:");
        s.append(keys().toString());
        s.append('\n');
        s.append("values:").append('[');
        for (Key key : keys()) {
            s.append("{").append(get(key).toString()).append("},");
        }
        s.deleteCharAt(s.length() - 1);
        s.append(']');
        return s.toString();
    }

    private class Node {
        private Node left;
        private Node right;
        private boolean color = BLACK;
        private Key key;
        private Value value;
        private int size;

        public Node(Key key, Value value, int size, boolean color) {
            this.key = key;
            this.value = value;
            this.size = size;
            this.color = color;
        }
    }

}

class UnitTest {
    public static void main(String[] args) {
        RedBlackBST<Integer, String> st = new RedBlackBST<>();
        st.put(1, "a");
        st.put(2, "b");
        st.put(3, "c");
        st.put(14, "y");
        st.put(5, "s");
        st.put(6, "c");
//        st.put(2, "e");
//        st.put(3, "g");

        System.out.println("st = " + st.toString());
        System.out.println("st size = " + st.size());
        System.out.println("========================");

        System.out.println("st.get(3)=" + st.get(3).toString());
        System.out.println("========================");

        System.out.println("st delete 2");
        st.delete(2);
        System.out.println("st = " + st.toString());
        System.out.println("st size = " + st.size());
        System.out.println("========================");

        System.out.println("st delete 14");
        st.delete(14);
        System.out.println("st = " + st.toString());
        System.out.println("st size = " + st.size());
    }
}
