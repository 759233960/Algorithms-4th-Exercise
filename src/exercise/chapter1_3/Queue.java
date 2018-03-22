package exercise.chapter1_3;

import edu.princeton.cs.algs4.StdIn;

import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int N;

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.next = null;
        last.item = item;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        N++;
    }

    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        N--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new QueueIterator();
    }

    private class Node {
        Item item;
        Node next;
    }

    private class QueueIterator implements Iterator<Item> {
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

class TestMode3 {
    public static void main(String[] args) {
        Queue<String> s;
        s = new Queue<>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) {
                s.enqueue(item);
            } else if (!s.isEmpty()) {
                System.out.print(s.dequeue() + "\t");
            }
        }
        System.out.println();
        System.out.println("(" + s.size() + " left on stack");
    }
}
