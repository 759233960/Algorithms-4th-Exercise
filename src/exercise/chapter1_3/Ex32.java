package exercise.chapter1_3;

class Steque<Item> {
    private Node first;
    private Node last;
    private int N;

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        N++;
    }

    public void push(Item item) {
        Node oldFirst = first;
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    public Item pop() {
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    private class Node {
        Node next;
        Item item;
    }
}
