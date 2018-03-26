package exercise.chapter1_3;

public class Ex21<Item> {


    private boolean find(Node node, String key) {
        while (node != null) {
            if (node.item.equals(key)) {
                return true;
            } else {
                node = node.next;
            }
        }
        return false;
    }

    private class Node {
        Item item;
        Node next;
    }

}
