package exercise.chapter1_3;

public class Ex27 {
    private int max(Node first) {
        if (first == null) {
            return 0;
        }
        int max = first.value;
        Node node = first;
        while (node != null) {
            if (max < node.value) {
                max = node.value;
            }
            node = node.next;
        }
        return max;
    }

    private class Node {
        Node next;
        int value;
    }
}
