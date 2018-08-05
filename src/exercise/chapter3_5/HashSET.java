package exercise.chapter3_5;

import com.sun.istack.internal.NotNull;
import exercise.chapter3_4.LinearProbingHashST;

public class HashSET<Key extends Comparable<Key>> {
    private static final Object ELEMENT = new Object();
    private LinearProbingHashST<Key, Object> hashSET;

    public HashSET() {
        hashSET = new LinearProbingHashST<>();
    }

    public int size() {
        return hashSET.size();
    }

    public boolean isEmpty() {
        return hashSET.isEmpty();
    }

    public void add(@NotNull Key key) {
        hashSET.put(key, ELEMENT);
    }

    public void delete(@NotNull Key key) {
        hashSET.delete(key);
    }

    public boolean contains(@NotNull Key key) {
        return hashSET.contains(key);
    }

    @Override
    public String toString() {
        return hashSET.toString();
    }
}
