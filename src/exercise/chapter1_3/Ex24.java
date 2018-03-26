package exercise.chapter1_3;

public class Ex24<Item> {

    private void removeAfter(Node node) {
        if (node == null || node.next == null) {
            return;
        }
        Node temp = node.next;
        node.next = node.next.next;
        temp = null;
    }

    private class Node {
        Node next;
        Item item;
    }
}
