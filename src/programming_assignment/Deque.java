package programming_assignment;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Yif on 6/21/2018.
 * first [ 1 <-> 2 <-> 3 <-> ... <-> n ] last
 */
public class Deque<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int N;

    public Deque() {

    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void addFirst(Item item) {
        if (null == item) {
            throw new IllegalArgumentException("Item can not be null");
        }
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.prev = null;
        if (isEmpty()) {
            last = first;
        } else {
            oldFirst.prev = first;
            first.next = oldFirst;
        }
        N++;
    }

    public void addLast(Item item) {
        if (null == item) {
            throw new IllegalArgumentException("Item can not be null");
        }
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
            last.prev = oldLast;
        }
        N++;
    }

    public Item removeFirst() {
        if (isEmpty()) {
            last = null;
            throw new NoSuchElementException("Deque is null");
        }
        Item item = first.item;
        Node oldFist = first;
        oldFist.next = null;//help GC
        oldFist.prev = null;//help GC
        first = first.next;
        N--;
        return item;
    }

    public Item removeLast() {
        if (isEmpty()) {
            first = null;
            throw new NoSuchElementException("Deque is null");
        }
        Item item = last.item;
        Node oldLast = last;
        oldLast.next = null;//help GC
        oldLast.prev = null;//help GC
        last = last.prev;
        N--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current.next != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }


    private class Node {
        Node next;
        Node prev;
        Item item;
    }


}
