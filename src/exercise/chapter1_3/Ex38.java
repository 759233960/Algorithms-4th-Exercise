package exercise.chapter1_3;

/**
 * Designed by array
 *
 * @param <Item>
 */
class GeneralizedQueue<Item> {
    private Item[] a;
    private int N;

    public GeneralizedQueue() {
        a = (Item[]) new Object[1];
        N = 0;
    }

    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < a.length; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void insert(Item x) {
        if (N == a.length) {
            resize(a.length * 2);
        }
        a[N++] = x;
    }

    public Item delete(int k) {
        Item item = a[k - 1];
        for (int i = k - 1; i < N - 1; i++) {
            a[i] = a[i + 1];
        }
        N--;
        if (N > 0 && N == a.length / 4) {
            resize(a.length / 2);
        }
        return item;
    }
}

/**
 * one-way linked queue
 *
 * @param <Item>
 */
class GeneralizedQueue2<Item> {
    private Node last;
    private Node first;
    private int N;

    public boolean isEmpty() {
        return N == 0;
    }

    public void insert(Item x) {
        Node oldLast = last;
        last = new Node();
        last.next = null;
        last.item = x;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        N++;
    }

    public Item delete(int k) {

        Item item = null;
        if (k <= N && k > 1) {
            Node temp = first;
            for (int i = 1; i < k - 1; i++) {
                temp = temp.next;
            }
            item = temp.next.item;
            temp.next = temp.next.next;
            N--;
        } else if (k == 1) {
            item = first.item;
            first = first.next;
            N--;
        }

        if (isEmpty()) {
            last = null;
        }
        return item;

    }


    private class Node {
        Node next;
        Item item;
    }


}
