package exercise.chapter3_4;

import exercise.chapter1_3.Queue;
import exercise.chapter3_1.SequentialSearchST;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SeparateChainingHashST<Key, Value> {
    private int N;
    private int M;
    private SequentialSearchST<Key, Value>[] st;

    public SeparateChainingHashST() {
        this(997);
    }

    public SeparateChainingHashST(int M) {
        this.M = M;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
        for (int i = 0; i < M; i++)
            st[i] = new SequentialSearchST();
    }

    private int hash(Key key) {
        if (key == null) throw new IllegalArgumentException();
        return ((key.hashCode() & 0x7fffffff) % M);
    }

    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException();
        if (isEmpty()) throw new NoSuchElementException();
        return (Value) st[hash(key)].get(key);
    }

    public void put(Key key, Value value) {
        if (key == null) throw new IllegalArgumentException();
        if (value == null) {
            delete(key);
        } else {
            if (!st[hash(key)].contains(key))
                N++;
            st[hash(key)].put(key, value);
        }
    }

    public void resize(int chains) {
        SeparateChainingHashST<Key, Value> temp = new SeparateChainingHashST(chains);
        for (int i = 0; i < M; i++) {
            Iterator<Key> iterator = st[i].keys().iterator();
            while (iterator.hasNext()) {
                Key key = iterator.next();
                Value value = st[i].get(key);
                temp.put(key, value);
            }
        }
        M = temp.M;
        N = temp.N;
        st = temp.st;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return N;
    }

    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException();
        if (isEmpty()) throw new NoSuchElementException();
        if (get(key) == null) throw new NoSuchElementException();
        if (st[hash(key)].contains(key))
            N--;
        st[hash(key)].delete(key);
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        if (isEmpty()) return queue;
        for (int i = 0; i < M; i++) {
            Iterator<Key> iterator = st[i].keys().iterator();
            while (iterator.hasNext()) {
                Key key = iterator.next();
                queue.enqueue(key);
            }
        }
        return queue;
    }
}
