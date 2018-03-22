package exercise.chapter1_3;

import edu.princeton.cs.algs4.StdIn;

public class Ex01 {
    public static void main(String[] args) {
        FixedCapacityStackOfStrings<String> s;
        s = new FixedCapacityStackOfStrings<>(100);
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) {
                s.push(item);
            } else if (!s.isEmpty()) {
                System.out.print(s.pop() + "\t");
            }
        }
        System.out.println("(" + s.size() + " left on stack");
    }
}

class FixedCapacityStackOfStrings<Item> {
    private Item[] a;
    private int N;

    public FixedCapacityStackOfStrings(int cap) {
        a = (Item[]) new Object[cap];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        if (N == a.length) resize(2 * a.length);
        a[N++] = item;
    }

    public Item pop() {
        Item item = a[--N];
        a[N] = null;
        if (N > 0 && N == a.length / 4) {
            resize(a.length / 2);
        }
        return item;
    }

    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    public boolean isFull() {
        return N == a.length;
    }
}
