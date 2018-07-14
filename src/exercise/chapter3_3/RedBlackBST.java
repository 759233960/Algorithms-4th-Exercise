package exercise.chapter3_3;

import java.util.NoSuchElementException;

public class RedBlackBST<Key extends Comparable<Key>, Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private Node root;

    private int size(Node x) {
        if (x == null) return 0;
        return x.N;
    }

    private boolean isRed(Node h) {
        return h.color == RED;
    }

    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = size(h.left) + size(h.right) + 1;
        return x;
    }

    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = size(h.left) + size(h.right) + 1;
        return x;
    }

    private void flipColors(Node h) {
        h.left.color = BLACK;
        h.right.color = BLACK;
        h.color = RED;
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
        root.color = BLACK;
    }

    private Node put(Node h, Key key, Value value) {
        if (h == null) return new Node(key, value, 1, RED);
        int cmp = key.compareTo(h.key);
        if (cmp < 0) put(h.left, key, value);
        else if (cmp > 0) put(h.right, key, value);
        else h.value = value;

        if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right)) flipColors(h);

        h.N = size(h.left) + size(h.right) + 1;
        return h;
    }

    public int size() {
        if (root == null) return 0;
        if (root.N < 0) throw new IllegalArgumentException();
        return root.N;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Key min() {
        if (isEmpty()) throw new NoSuchElementException();
        return min(root).key;
    }

    private Node min(Node x) {
        if (x.left == null) return x;
        return min(x.left);
    }

    public Key max() {
        if (isEmpty()) throw new NoSuchElementException();
        return max(root.right).key;
    }

    private Node max(Node x) {
        if (x.right == null) return x;
        return max(x.right);
    }

    /**
     * private Node moveRedLeft(Node h) {
     * //假设h为红色，h.left 和 h.left.left 都是黑色
     * //将h.left 或者 h.left的子节点之一变红
     * flipColors(h);
     * if (isRed(h.right.left)) {
     * h.right = rotateRight(h.right);
     * h = rotateLeft(h);
     * }
     * return h;
     * }
     * <p>
     * public void deleteMin() {
     * if (!isRed(root.left) && !isRed(root.left.left))
     * root.color = RED;
     * root = deleteMin(root);
     * if (!isEmpty()) root.color = BLACK;
     * }
     * <p>
     * private Node deleteMin(Node h) {
     * if (h.left == null) return null;
     * if (!isRed(h.left) && !isRed(h.left.left))
     * h = moveRedLeft(h);
     * h.left = deleteMin(h.left);
     * return balance(h);
     * }
     * <p>
     * private Node balance(Node h) {
     * <p>
     * }
     */

    private class Node {

        private Node left;
        private Node right;
        private Key key;
        private Value value;
        private int N;
        private boolean color;

        public Node(Key key, Value value, int n, boolean color) {
            this.key = key;
            this.value = value;
            N = n;
            this.color = color;
        }
    }

}
