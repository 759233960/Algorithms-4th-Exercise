package exercise.chapter3_5;


import exercise.chapter3_3.RedBlackBST;

import java.util.Iterator;

public class SETdouble implements Iterable<Double> {
    private static final Object ELEMENT = new Object();
    private RedBlackBST<Double, Object> st;

    public SETdouble() {
        st = new RedBlackBST<>();
    }

    public int size() {
        return st.size();
    }

    public boolean isEmpty() {
        return st.isEmpty();
    }

    public boolean contains(double key) {
        return st.get(key) != null;
    }

    public void put(double key) {
        st.put(key, ELEMENT);
    }

    public void delete(double key) {
        st.delete(key);
    }

    public Iterable<Double> keys() {
        return st.keys();
    }

    public double min() {
        return st.min();
    }

    public double max() {
        return st.max();
    }

    public Object get(double key) {
        return st.get(key);
    }

    public double ceiling(double key) {
        double result = st.ceiling(key);
        return result;
    }

    public double floor(double key) {
        double result = st.floor(key);
        return result;
    }

    @Override
    public Iterator<Double> iterator() {
        return st.iterator();
    }
}
