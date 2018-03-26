package exercise.chapter1_3;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class RandomBag<Item> implements Iterable<Item> {

    private Item[] a;
    private int N;

    public RandomBag() {
        List<Item> list = Arrays.asList(a);
        Collections.shuffle(list);
        a = (Item[]) list.toArray();
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void add(Item item) {
        if (N == a.length) {
            resize(a.length * 2);
        }
        a[N++] = item;
    }

    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    @Override
    public Iterator<Item> iterator() {
        return new RandomBagIterator();
    }

    private class RandomBagIterator implements Iterator<Item> {
        private int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return a[--i];
        }
    }
}
