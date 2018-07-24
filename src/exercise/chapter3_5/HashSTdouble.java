package exercise.chapter3_5;

import exercise.chapter1_3.Queue;

import java.util.NoSuchElementException;

public class HashSTdouble<Value> {
    private int N;      //total number of item
    private int M;      //Size of map , M > N
    private double[] keys;
    private Value[] values;

    public HashSTdouble() {
        this(16);
    }

    public HashSTdouble(int cap) {
        this.M = cap;
        this.N = 0;
        keys = new double[M];
        values = (Value[]) new Object[M];
    }

    private int hash(double key) {
        long result = Double.doubleToLongBits(key);
        return ((int) ((result >>> 32) & 0x7fffffff) % M);
    }

    private void resize(int cap) {//must be needed
        HashSTdouble<Value> t;
        t = new HashSTdouble<>(cap);
        for (int i = 0; i < M; i++)
            t.put(keys[i], values[i]);
        keys = t.keys;
        values = t.values;
        M = t.M;
    }

    public void put(double key, Value value) {
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

    public void delete(double key) {
        if (isEmpty() || !contains(key)) throw new NoSuchElementException();
        int i = hash(key);
        while (key != (keys[i])) {
            i = (i + 1) % M;
        }
        keys[i] = 0.0;
        values[i] = null;
        i = (i + 1) % M;
        while (values[i] != null) {
            double doubleToRedo = keys[i];
            Value valueToRedo = values[i];
            keys[i] = 0.0;
            values[i] = null;
            N--;
            put(doubleToRedo, valueToRedo);
            i = (i + 1) % M;
        }
        N--;
        if (N > 0 && N <= M / 8) resize(M / 2);
    }

    public Value get(double key) {
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

    public boolean contains(double key) {
        return get(key) != null;
    }

    public Iterable<Double> keys() {
        Queue<Double> queue = new Queue<>();
        for (int i = 0; i < N; i++) {
            queue.enqueue(keys[i]);
        }
        return queue;
    }
}
