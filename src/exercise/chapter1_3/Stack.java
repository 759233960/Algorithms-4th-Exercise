package exercise.chapter1_3;

import edu.princeton.cs.algs4.StdIn;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

/**
 * 链表栈
 *
 * @param <Item>
 */
public class Stack<Item> implements Iterable<Item> {
    private Node first;
    private int N;

    public Stack(Stack<Item> stack) {
        first = new Node(stack.first);
    }

    public Stack() {
        first = null;
        N = 0;
    }

    public boolean isEmpty() {
        return first == null;
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

    public Item pop() throws NullPointerException {
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack Null");
        return first.item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new StackIterator();
    }

    private class Node {
        Item item;
        Node next;

        Node() {
        }

        /**
         * Ex42
         *
         * @param x
         */
        Node(Node x) {
            item = x.item;
            if (x.next != null) {
                next = new Node(x.next);
            }
            N++;
        }
    }

    private class StackIterator implements Iterator<Item> {
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

        }

        @Override
        public void forEachRemaining(Consumer<? super Item> action) {

        }
    }
}

class TestMode2 {
    public static void main(String[] args) {
        Stack<String> s;
        s = new Stack<>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) {
                s.push(item);
            } else if (!s.isEmpty()) {
                System.out.print(s.pop() + "\t");
            }
        }
        System.out.println();
        System.out.println("(" + s.size() + " left on stack");
    }
}


