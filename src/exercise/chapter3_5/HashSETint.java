package exercise.chapter3_5;

import exercise.chapter1_3.Queue;

import java.util.NoSuchElementException;

public class HashSETint {
    private int N;      //total number of item
    private int M;      //Size of map , M > N
    private int[] keys;

    public HashSETint() {
        this(16);
    }

    public HashSETint(int cap) {
        this.M = cap;
        this.N = 0;
        keys = new int[M];
    }

    private int hash(int key) {
        return ((key & 0x7fffffff) % M);
    }

    private void resize(int cap) {//must be needed
        HashSETint t;
        t = new HashSETint(cap);
        for (int i = 0; i < M; i++)
            t.put(keys[i]);
        keys = t.keys;
        M = t.M;
    }

    public void put(int key) {
        if (N >= M / 2) resize(2 * M);
        int i;
        for (i = hash(key); keys[i] != 0; i = (i + 1) % M) {
            if (keys[i] == key) {
                return;
            }
        }
        keys[i] = key;
        N++;
    }

    public void delete(int key) {
        if (isEmpty() || !contains(key)) throw new NoSuchElementException();
        int i = hash(key);
        while (key != keys[i]) {
            i = (i + 1) % M;
        }
        keys[i] = 0;
        i = (i + 1) % M;
        while (keys[i] != 0) {
            int intToRedo = keys[i];
            keys[i] = 0;
            N--;
            put(intToRedo);
            i = (i + 1) % M;
        }
        N--;
        if (N > 0 && N <= M / 8) resize(M / 2);
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return N;
    }

    public boolean contains(int key) {
        for (int i = 0; i < size(); i++)
            if (keys[i] == key)
                return true;
        return false;
    }

    public Iterable<Integer> keys() {
        Queue<Integer> queue = new Queue<>();
        for (int i = 0; i < N; i++) {
            queue.enqueue(keys[i]);
        }
        return queue;
    }
}
