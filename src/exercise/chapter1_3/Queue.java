package exercise.chapter1_3;

import edu.princeton.cs.algs4.StdIn;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<Item> implements Iterable<Item> {

    private Node<Item> first;
    private Node<Item> last;
    private int N;

    public Queue() {
    }

    /**
     * Ex41 - copy queue
     *
     * @param q
     */
    public Queue(Queue<Item> q) {
        N = 0;
        first = last = null;
        Queue<Item> temp = new Queue<>();
        while (!q.isEmpty()) {
            Item item = q.dequeue();
            temp.enqueue(item);
        }
        while (!temp.isEmpty()) {
            Item item = temp.dequeue();
            q.enqueue(item);
            enqueue(item);
        }
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void enqueue(Item item) {
        Node<Item> oldLast = last;
        last = new Node<Item>();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        N++;
    }

    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException();
        Item item = first.item;
        first = first.next;
        N--;
        if (isEmpty()) last = null;
        return item;
    }

    public void printQueue() {
        Node node = first;
        while (node != null) {
            System.out.print(node.item);
            node = node.next;
        }
        System.out.println();
    }

    public Item[] toArrays() {
        Item[] items = (Item[]) new Object[N];
        Node<Item> x = first;
        int i = 0;
        for (Item item : this) {
            items[i] = item;
            i++;
        }

//        while (x!= null) {
//            items[i] = x.item;
//            x = x.next;
//            i++;
//        }

//        for (int i = 0; i < N; i++) {
//            items[i] = x.item;
//            if (x.next == null)
//                return items;
//            x = x.next;
//        }
        return items;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item);
            s.append(' ');
        }
        s.deleteCharAt(s.length() - 1);
        return s.toString();
    }

    @Override
    public Iterator<Item> iterator() {
        return new QueueIterator();
    }

    private class Node<Item> {
        Item item;
        Node<Item> next;
    }

    private class QueueIterator implements Iterator<Item> {
        private Node<Item> current = first;

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

/**
 * Ex41
 */
class TestMode4 {
    public static void main(String[] args) {
        Queue<Character> t = new Queue<>();
        String s = "hello world";
        char[] c = s.toCharArray();
        for (char chars : c) {
            t.enqueue(chars);
        }
        System.out.println("To Array:" + Arrays.toString(t.toArrays()));
        System.out.println("To String:" + t.toString());
        System.out.println("--------------");
        t.printQueue();
        System.out.println("==============" + t.size());
        Queue<Character> r = new Queue<>(t);
        System.out.println();
        r.printQueue();
        t.printQueue();
        System.out.println("===============");
        r.dequeue();
        r.printQueue();
        t.printQueue();


    }
}
