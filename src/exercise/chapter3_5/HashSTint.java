package exercise.chapter3_5;

import exercise.chapter1_3.Queue;

import java.util.NoSuchElementException;

public class HashSTint<Value> {
    private int N;      //total number of item
    private int M;      //Size of map , M > N
    private int[] keys;
    private Value[] values;

    public HashSTint() {
        this(16);
    }

    public HashSTint(int cap) {
        this.M = cap;
        this.N = 0;
        keys = new int[M];
        values = (Value[]) new Object[M];
    }

    private int hash(int key) {
        return ((key & 0x7fffffff) % M);
    }

    private void resize(int cap) {//must be needed
        HashSTint<Value> t;
        t = new HashSTint<>(cap);
        for (int i = 0; i < M; i++)
            t.put(keys[i], values[i]);
        keys = t.keys;
        values = t.values;
        M = t.M;
    }

    public void put(int key, Value value) {
        if (N >= M / 2) resize(2 * M);
        if (value == null) delete(key);
        int i;
        for (i = hash(key); values[i] != null; i = (i + 1) % M) {
            if (keys[i] == key) {
                values[i] = value;
                return;
            }
        }
        keys[i] = key;
        values[i] = value;
        N++;
    }

    public void delete(int key) {
        if (isEmpty() || !contains(key)) throw new NoSuchElementException();
        int i = hash(key);
        while (key != keys[i]) {
            i = (i + 1) % M;
        }
        keys[i] = 0;
        values[i] = null;
        i = (i + 1) % M;
        while (values[i] != null) {
            int intToRedo = keys[i];
            Value valueToRedo = values[i];
            keys[i] = 0;
            values[i] = null;
            N--;
            put(intToRedo, valueToRedo);
            i = (i + 1) % M;
        }
        N--;
        if (N > 0 && N <= M / 8) resize(M / 2);
    }

    public Value get(int key) {
        if (isEmpty()) throw new NoSuchElementException();
        for (int i = hash(key); values[i] != null; i = (i + 1) % M) {
            if (keys[i] == key) {
                return values[i];
            }
        }
        return null;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return N;
    }

    public boolean contains(int key) {
        return get(key) != null;
    }

    public Iterable<Integer> keys() {
        Queue<Integer> queue = new Queue<>();
        for (int i = 0; i < N; i++) {
            queue.enqueue(keys[i]);
        }
        return queue;
    }
}
