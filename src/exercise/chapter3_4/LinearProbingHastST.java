package exercise.chapter3_4;

import java.util.NoSuchElementException;

public class LinearProbingHastST<Key, Value> {
    private int N;      //total number of item
    private int M;      //Size of map , M > N
    private Key[] keys;
    private Value[] values;

    public LinearProbingHastST() {
        this(16);
    }

    public LinearProbingHastST(int cap) {
        this.M = cap;
        this.N = 0;
        keys = (Key[]) new Object[M];
        values = (Value[]) new Object[M];
    }

    private int hash(Key key) {
        if (key == null) throw new IllegalArgumentException();
        return ((key.hashCode() & 0x7fffffff) % M);
    }

    private void resize(int cap) {//must be needed
        LinearProbingHastST<Key, Value> t;
        t = new LinearProbingHastST<>(cap);
        for (int i = 0; i < M; i++)
            if (keys[i] != null)
                t.put(keys[i], values[i]);
        keys = t.keys;
        values = t.values;
        M = t.M;
    }

    public void put(Key key, Value value) {
        if (key == null) throw new IllegalArgumentException();
        if (N >= M / 2) resize(2 * M);
        if (value == null) delete(key);
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) {
                values[i] = value;
                return;
            }
        }
        keys[i] = key;
        values[i] = value;
        N++;
    }

    public void delete(Key key) {
        if (key == null) return;
        if (isEmpty() || !contains(key)) throw new NoSuchElementException();
        int i = hash(key);
        while (!key.equals(keys[i])) {
            i = (i + 1) % M;
        }
        keys[i] = null;
        values[i] = null;
        i = (i + 1) % M;
        while (keys[i] != null) {
            Key keyToRedo = keys[i];
            Value valueToRedo = values[i];
            keys[i] = null;
            values[i] = null;
            N--;
            put(keyToRedo, valueToRedo);
            i = (i + 1) % M;
        }
        N--;
        if (N > 0 && N <= M / 8) resize(M / 2);
    }

    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException();
        if (isEmpty()) throw new NoSuchElementException();
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) {
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

    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException();
        return get(key) != null;
    }
}
