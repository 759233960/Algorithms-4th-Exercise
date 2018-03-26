package exercise.chapter1_3;

public class Ex26<Item> {
    private void remove(Node first, String key) {
        while (first != null) {
            if (first.item.equals(key)) {
                Node temp = first.next;
                first.next = first.next.next;
                temp = null;
            }
            first = first.next;
        }
    }

    private class Node {
        Node next;
        Item item;
    }
}
