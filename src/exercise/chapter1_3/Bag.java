package exercise.chapter1_3;

import java.util.Iterator;

public class Bag<Item> implements Iterable<Item> {

    private Node first;

    public void add(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }

    @Override
    public Iterator<Item> iterator() {
        return new BagIterator();
    }

    @Override
    public String toString() {
        StringBuffer s = new StringBuffer();
        forEach(val -> s.append(val).append(" "));
        return s.toString();
    }

    private class Node {
        Node next;
        Item item;
    }

    private class BagIterator implements Iterator<Item> {
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
    }
}

class UnitTest {
    public static void main(String[] args) {
        Bag<Integer> bag = new Bag<>();

        for (int i = 0; i < 10; i++)
            bag.add(i);

        System.out.println(bag);
    }
}