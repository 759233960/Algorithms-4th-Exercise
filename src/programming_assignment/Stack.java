package programming_assignment;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Yif on 6/21/2018.
 * [ 1 -> 2 -> 3 -> ... -> n ] first
 * isEmpty()
 * size()
 * push()
 * pop()
 * -> Iterable
 */
public class Stack<Item> implements Iterable<Item> {
    private Node first;
    private int N;

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    public Item pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is null");
        }
        Item temp = first.item;
        first = first.next;
        N--;
        return temp;
    }

    public Item peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is null");
        }
        return first.item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
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
        Item item;
        Node next;
    }
}
