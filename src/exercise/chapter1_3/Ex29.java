package exercise.chapter1_3;

public class Ex29<Item> {
    private Node last;
    private int N;

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return last == null;
    }

    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.next = null;
        last.item = item;

        if (!isEmpty()) {
            last.next = oldLast.next;
            oldLast.next = last;
        }
        N++;
    }

    public Item dequeue() {
        Item item = last.next.item;
        last.next = last.next.next;
        if (isEmpty()) {
            last = null;
        }
        N--;
        return item;
    }

    private class Node {
        Node next;
        Item item;
    }
}
