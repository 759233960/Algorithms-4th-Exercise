package exercise.chapter1_3;

public class Ex30<Item> {
    private Node reverse(Node first) {
        if (first == null) {
            return null;
        }

        if (first.next == null) {
            return first;
        }

        Node second = first.next;
        Node rest = reverse(second);
        second.next = first;
        first.next = null;
        return rest;
    }

    private Node reverseLink(Node first) {
        if (first == null) {
            return null;
        }
        Stack<Item> stack = new Stack();
        while (first != null) {
            stack.push(first.item);
            first = first.next;
        }

        Node reverse = first;
        while (!stack.isEmpty()) {
            Node oldFirst = first;
            first = new Node();
            oldFirst.next = first;
            first.next = null;
            first.item = stack.pop();
        }
        return reverse;
    }

    private class Node {
        Node next;
        Item item;
    }

}
