package exercise.chapter1_3;

public class Ex25<Item> {
    private void insertAfter(Node x, Node t) {
        if (x == null || t == null) {
            return;
        }
        t.next = x.next;
        x.next = t;
    }

    private class Node {
        Node next;
        Item item;
    }
}
