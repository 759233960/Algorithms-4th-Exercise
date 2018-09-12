package other.summary;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

abstract class BaseStructure<Item> {

    abstract int size();

    abstract boolean isEmpty();

    class Node {
        Node next;
        Item item;
    }
}

class ArrayStack<Item> extends BaseStructure<Item> implements Iterable<Item> {
    private Item[] data;
    private int N;

    public ArrayStack(int n) {
        data = (Item[]) new Object[n];
        N = 0;
    }

    public ArrayStack() {
        this(10);
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void push(Item item) {
        if (N == data.length)
            resize(2 * N);
        data[N++] = item;
    }

    public Item pop() {
        Item item = data[--N];
        data[N] = null;
        if (N == data.length / 4) resize(data.length / 2);
        return item;
    }

    private void resize(int n) {
        Item[] copy = (Item[]) new Object[n];
        for (int i = 0; i < N; i++)
            copy[i] = data[i];
        data = copy;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ArrayStackIterator();
    }

    private class ArrayStackIterator implements Iterator<Item> {

        private int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return data[--i];
        }
    }
}

class ArrayQueue<Item> extends BaseStructure<Item> implements Iterable<Item> {

    private int head;
    private int tail;
    private Item[] data;

    public ArrayQueue() {
        this(10);
    }

    public ArrayQueue(int n) {
        data = (Item[]) new Object[n];
        head = 0;
        tail = 0;
    }

    public void enqueue(Item item) {
        if (tail == data.length) resize(data.length * 2);
        data[tail++] = item;
    }

    public Item dequeue() {
        Item item = data[head];
        data[head] = null;
        head++;
        if (!isEmpty() && size() == data.length / 4) resize(data.length / 2);
        return item;
    }

    @NotNull
    @Override
    public Iterator<Item> iterator() {
        return new ArrayQueueIterator();
    }

    @Override
    public int size() {
        return tail - head;
    }

    @Override
    public boolean isEmpty() {
        return tail - head <= 0;
    }

    private void resize(int n) {
        Item[] copy = (Item[]) new Object[n];
        for (int i = head; i < tail; i++)
            copy[i] = data[i];
        data = copy;
    }

    private class ArrayQueueIterator implements Iterator<Item> {
        private int i = head;
        private int j = tail;

        @Override
        public boolean hasNext() {
            return j - i > 0;
        }

        @Override
        public Item next() {
            return data[i++];
        }
    }
}

class LinkedStack<Item> extends BaseStructure<Item> implements Iterable<Item> {

    private Node first;
    private int N;

    public LinkedStack() {
        first = null;
        N = 0;
    }

    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    public Item pop() {
        if (isEmpty()) return null;
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    @Override
    int size() {
        return N;
    }

    @Override
    boolean isEmpty() {
        return N == 0;
    }

    @NotNull
    @Override
    public Iterator<Item> iterator() {
        return new LinkedStackIterator();
    }

    private class LinkedStackIterator implements Iterator<Item> {
        private Node curr = first;

        @Override
        public boolean hasNext() {
            return curr != null;
        }

        @Override
        public Item next() {
            Item item = curr.item;
            curr = curr.next;
            return item;
        }
    }
}

class LinkedQueue<Item> extends BaseStructure<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int N;

    public LinkedQueue(int n) {
        first = null;
        last = null;
        N = 0;
    }

    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else oldLast.next = last;
        N++;
    }

    public Item dequeue() {
        if (isEmpty()) return null;
        Item item = first.item;
        first = first.next;
        N--;
        if (isEmpty()) last = null;
        return item;
    }

    @NotNull
    @Override
    public Iterator<Item> iterator() {
        return new LinkedQueueIterator();
    }

    @Override
    int size() {
        return N;
    }

    @Override
    boolean isEmpty() {
        return N == 0;
    }

    private class LinkedQueueIterator implements Iterator<Item> {

        private Node curr = first;

        @Override
        public boolean hasNext() {
            return curr != null;
        }

        @Override
        public Item next() {
            Item item = curr.item;
            curr = curr.next;
            return item;
        }
    }
}

class LinkedBag<Item> extends BaseStructure<Item> implements Iterable<Item> {

    private Node first;
    private int N;

    public LinkedBag() {
        first = null;
        N = 0;
    }

    public void add(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    public boolean contains(Item item) {
        if (isEmpty()) return false;
        for (Item i : this)
            if (i.equals(item)) return true;
        return false;
    }

    @NotNull
    @Override
    public Iterator<Item> iterator() {
        return new LinkedBagIterator();
    }

    @Override
    int size() {
        return N;
    }

    @Override
    boolean isEmpty() {
        return N == 0;
    }

    private class LinkedBagIterator implements Iterator<Item> {

        private Node curr = first;

        @Override
        public boolean hasNext() {
            return curr != null;
        }

        @Override
        public Item next() {
            Item item = curr.item;
            curr = curr.next;
            return item;
        }
    }
}

class QuickFind {
    private int[] id;
    private int count;

    public QuickFind(int n) {
        id = new int[n];
        count = n;
        for (int i = 0; i < n; i++) id[i] = i;
    }

    public int find(int p) {
        return id[p];
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int pID = find(p);
        int qID = find(q);
        if (pID == qID) return;

        for (int i = 0; i < id.length; i++)
            if (id[i] != pID) id[i] = qID;
        count--;
    }

    public int count() {
        return count;
    }
}

class QuickUnion {
    private int[] id;
    private int count;

    public QuickUnion(int n) {
        id = new int[n];
        count = n;
        for (int i = 0; i < n; i++) id[i] = i;
    }

    public int count() {
        return count;
    }

    public int find(int p) {
        while (p != id[p]) p = id[p];
        return p;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;

        id[pRoot] = qRoot;
        count--;
    }
}

class WeightedQuickUnion {
    private int[] id;
    private int[] sz;
    private int count;

    public WeightedQuickUnion(int n) {
        id = new int[n];
        sz = new int[n];
        count = n;
        for (int i = 0; i < n; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    public int count() {
        return count;
    }

    public int find(int p) {
        int child = p;
        while (p != id[p]) p = id[p];
        while (id[child] != p) {
            int temp = child;
            child = id[child];
            id[temp] = p;
        }
        return p;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;

        if (sz[p] < sz[q]) {
            id[pRoot] = qRoot;
            sz[p] = sz[q];
            sz[q] += sz[p];
        } else {
            id[qRoot] = pRoot;
            sz[q] = sz[p];
            sz[p] += sz[q];
        }
        count--;
    }
}