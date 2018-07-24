package exercise.chapter3_5;


import exercise.chapter3_3.RedBlackBST;

import java.util.Iterator;

public class STint<Value> implements Iterable<Integer> {
    private RedBlackBST<Integer, Value> st;

    public STint() {
        st = new RedBlackBST<>();
    }

    public int size() {
        return st.size();
    }

    public boolean isEmpty() {
        return st.isEmpty();
    }

    public boolean contains(int key) {
        return st.get(key) != null;
    }

    public void put(int key, Value value) {
        if (value == null) {
            delete(key);
        } else {
            st.put(key, value);
        }
    }

    public void delete(int key) {
        st.delete(key);
    }

    public Iterable<Integer> keys() {
        return st.keys();
    }

    public int min() {
        return st.min();
    }

    public int max() {
        return st.max();
    }

    public Value get(int key) {
        return st.get(key);
    }

    public int ceiling(int key) {
        int result = st.ceiling(key);
        return result;
    }

    public int floor(int key) {
        int result = st.floor(key);
        return result;
    }

    @Override
    public Iterator<Integer> iterator() {
        return st.iterator();
    }
}
