package exercise.chapter3_1;

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
        int i = rank(key);
        if (i < N && key.compareTo(keys[i]) == 0)
            return values[i];
        else
            return null;
    }

    public int rank(Key key) {
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

    public void delete() {

    }
}
