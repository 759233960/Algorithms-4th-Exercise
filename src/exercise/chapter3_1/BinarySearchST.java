package exercise.chapter3_1;

import exercise.chapter1_3.Queue;

import java.util.NoSuchElementException;

public class BinarySearchST<Key extends Comparable<Key>, Value> {
    private Key[] keys;
    private Value[] values;
    private int N;

    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public Value get(Key key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        if (isEmpty()) return null;
        int i = rank(key);
        if (i < N && key.compareTo(keys[i]) == 0)
            return values[i];
        else
            return null;
    }

    public int rank(Key key) {
        if (key == null) throw new IllegalArgumentException();
        int lo = 0, hi = N - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int comp = key.compareTo(keys[mid]);
            if (comp == 0) {
                return mid;
            } else if (comp > 0) {
                lo = mid + 1;
            } else if (comp < 0) {
                hi = mid - 1;
            }
        }
        return lo;
    }

    public void put(Key key, Value value) {
        if (key == null) throw new IllegalArgumentException();
        if (value == null) {
            delete(key);
            return;
        }
        int i = rank(key);
        if (i < N && key.compareTo(keys[i]) == 0) {
            keys[i] = key;
            values[i] = value;
            return;
        }
        for (int j = N; j > i; j--) {
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];
        }
        keys[i] = key;
        values[i] = value;
        N++;
    }

    public void delete(Key key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        if (isEmpty()) {
            return;
        }
        int i = rank(key);
        if (i < N && key.compareTo(keys[i]) == 0) {
            for (int j = i; j < N - 1; j++) {
                keys[j] = keys[j + 1];
                values[j] = values[j + 1];
            }
            keys[N] = null;
            values[N] = null;
            N--;
            if (N > 0 && N == keys.length / 4) {
                resize(keys.length / 2);
            }
        }
    }

    public Key min() {
        if (isEmpty()) throw new NoSuchElementException();
        return keys[0];
    }

    public Key max() {
        if (isEmpty()) throw new NoSuchElementException();
        return keys[N - 1];
    }

    public Key select(int i) {
        if (i >= N && i < 0) throw new NoSuchElementException();
        return keys[i];
    }

    public Key ceiling(Key key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        int i = rank(key);
        return i == N ? null : keys[i];
    }

    public Key floor(Key key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        int i = rank(key);
        if (i < N && key.compareTo(keys[i]) == 0) {
            return keys[i];
        }
        return i == 0 ? null : keys[i - 1];
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        if (lo == null || hi == null) {
            throw new IllegalArgumentException();
        }
        Queue<Key> queue = new Queue<>();
        if (lo.compareTo(hi) > 0) {
            return queue;
        }
        for (int i = rank(lo); i < rank(hi); i++) {
            queue.enqueue(keys[i]);
        }
        if (contains(hi)) {
            queue.enqueue(keys[rank(hi)]);
        }
        return queue;
    }

    public boolean contains(Key key) {
        int lo = 0, hi = N;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int comp = key.compareTo(keys[mid]);
            if (comp == 0) {
                return true;
            } else if (comp > 0) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return false;
    }

    private void resize(int capacity) {
        assert capacity >= N;
        Key[] tempK = (Key[]) (new Comparable[capacity]);
        Value[] tempV = (Value[]) new Object[capacity];

        for (int i = 0; i < N; i++) {
            tempK[i] = keys[i];
            tempV[i] = values[i];
        }

        keys = tempK;
        values = tempV;
    }

}
