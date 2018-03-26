package exercise.chapter1_3;

public class Ex28 {
    private int max(Node first) {
        if (first == null) {
            return 0;
        }
        int max = first.value;
        Node node = first;
        if (max < node.value) {
            max = node.value;
        }
        return max(node.next);
    }

    private class Node {
        Node next;
        int value;
    }
}
