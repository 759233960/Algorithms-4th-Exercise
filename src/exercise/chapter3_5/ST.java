package exercise.chapter3_5;

import com.sun.istack.internal.NotNull;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import exercise.chapter3_3.RedBlackBST;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ST<Key extends Comparable<Key>, Value> implements Iterable<Key> {
    private RedBlackBST<Key, Value> st;

    public ST() {
        st = new RedBlackBST<>();
    }

    /**
     * Unit tests the {@code ST} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        ST<String, Integer> st = new ST<String, Integer>();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }
        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));
    }

    public int size() {
        return st.size();
    }

    public boolean isEmpty() {
        return st.isEmpty();
    }

    public boolean contains(@NotNull Key key) {
        if (key == null) throw new IllegalArgumentException();
        return st.get(key) != null;
    }

    public void put(@NotNull Key key, Value value) {
        if (key == null) throw new IllegalArgumentException();
        if (value == null) {
            delete(key);
        } else {
            st.put(key, value);
        }
    }

    public void delete(@NotNull Key key) {
        st.delete(key);
    }

    public Iterable<Key> keys() {
        return st.keys();
    }

    public Key min() {
        return st.min();
    }

    public Key max() {
        return st.max();
    }

    public Value get(Key key) {
        return st.get(key);
    }

    public Key ceiling(Key key) {
        Key result = st.ceiling(key);
        if (result == null) throw new NoSuchElementException();
        return result;
    }

    public Key floor(Key key) {
        Key result = st.floor(key);
        if (result == null) throw new NoSuchElementException();
        return result;
    }

    @Override
    public Iterator<Key> iterator() {
        return st.iterator();
    }
}
