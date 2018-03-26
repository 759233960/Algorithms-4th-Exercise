package exercise.chapter1_3;

import java.util.Iterator;

class Deque<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int N;

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void pushLeft(Item item) {
        if (isEmpty()) {
            first = last;
        }
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.prev = null;
        first.next = oldFirst;
        oldFirst.prev = first;
        N++;
    }

    public void pushRight(Item item) {
        if (isEmpty()) {
            first = last;
        }
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.prev = oldLast;
        last.next = null;
        oldLast.next = last;
        N++;
    }

    public Item popLeft() {
        if (isEmpty()) {
            return null;
        }
        Item item = first.item;
        first = first.next;
        first.prev = null;
        N--;
        return item;
    }

    public Item popRight() {
        if (isEmpty()) {
            return null;
        }
        Item item = last.item;
        last = last.prev;
        last.next = null;
        N--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class Node {
        Node next;
        Node prev;
        Item item;
    }

    private class DequeIterator implements Iterator<Item> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            if (isEmpty()) {
                current = null;
            }
            return item;
        }
    }
}

class ResizingArrayDeque<Item> implements Iterable<Item> {
    private Item[] a = (Item[]) new Object[1];

    private int N = 0;

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void pushLeft(Item item) {
        if (N == a.length) {
            resize(a.length * 2);
        }
        Item[] temp = (Item[]) new Object[a.length];
        for (int i = 0; i < N; i++) {
            temp[i + 1] = a[i];
        }
        temp[0] = item;
        a = temp;
        N++;
    }

    public void pushRight(Item item) {
        if (N == a.length) {
            resize(a.length * 2);
        }
        a[N++] = item;
    }

    public Item popLeft() {
        Item item = a[0];
        for (int i = 0; i < N - 1; i++) {
            a[i] = a[i + 1];
        }
        a[--N] = null;
        if (N > 0 && N == a.length / 4) {
            resize(a.length / 2);
        }
        return item;
    }


    public Item popRight() {
        Item item = a[--N];
        a[N] = null;
        if (N > 0 && N == a.length / 4) {
            resize(a.length / 2);
        }
        return item;
    }


    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }


    @Override
    public Iterator<Item> iterator() {
        return new ResizingIterator();
    }

    private class ResizingIterator implements Iterator<Item> {
        private int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return a[--i];
        }
    }
}
