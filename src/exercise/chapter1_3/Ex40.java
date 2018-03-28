package exercise.chapter1_3;

class MoveToFront<Item> {
    private Node first;

    private int N;

    public MoveToFront() {
        first = null;
        N = 0;
    }

    public void push(Item item) {
        Node temp = first;
        while (temp != null) {
            if (temp.item.equals(item))
                return;
            temp = temp.next;
        }
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    public void read(Item item) {
        Node temp = first;
        while (temp.next != null) {
            if (temp.next.item.equals(item)) {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
        push(item);
    }

    public Item pop() {
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void printValue() {
        Node node = first;
        while (node.next != null) {
            System.out.print(node.item + " ");
            node = node.next;
        }
        System.out.println();
    }

    private class Node {
        Node next;
        Item item;
    }
}

public class Ex40 {
    public static void main(String[] args) {
        MoveToFront<Character> move = new MoveToFront<>();
//        System.out.print("Please input String : ");
//        while (StdIn.hasNextChar()) {
//            move.push(StdIn.readChar());
//        }
//        System.out.println();
//        move.printValue();
//
//        System.out.print("Please input char : ");
//        while (StdIn.hasNextChar()) {
//            move.read(StdIn.readChar());
//        }
//        System.out.println();
//        move.printValue();

//        String s = " abcdsfsfsas";
        char[] chars = new char[]{'a', 'b', 'c', 'd', 's', 'f', 's', 'f', 's', 'a', 's'};
        for (char c : chars) {
            move.push(c);
        }
        move.printValue();
        move.read('s');
        move.printValue();
    }
}
