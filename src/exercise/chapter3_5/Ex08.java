package exercise.chapter3_5;

import exercise.chapter1_3.Queue;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class Ex08<Key, Value> {
    private int N;      //total number of item
    private int M;      //Size of map , M > N
    private Key[] keys;
    private Value[] values;

    public Ex08() {
        this(16);
    }

    public Ex08(int cap) {
        this.M = cap;
        this.N = 0;
        keys = (Key[]) new Object[M];
        values = (Value[]) new Object[M];
    }

    public static void main(String[] args) {
        Ex08<Integer, String> st = new Ex08<>();
        st.put(1, "a");
        st.put(2, "b");
        st.put(3, "c");
        st.put(14, "y");
        st.put(5, "s");
        st.put(6, "c");
        st.put(2, "e");
        st.put(3, "g");

        System.out.println("st = " + st.toString());
        System.out.println("st size = " + st.size());

        System.out.println("st.get(3)=" + Arrays.toString(st.get(3)));

        st.delete(2);
        System.out.println("st = " + st.toString());
        System.out.println("st size = " + st.size());

        st.delete(14);
        System.out.println("st = " + st.toString());
        System.out.println("st size = " + st.size());
    }

    private int hash(Key key) {
        if (key == null) throw new IllegalArgumentException();
        return ((key.hashCode() & 0x7fffffff) % M);
    }

    private void resize(int cap) {//must be needed
        Ex08<Key, Value> t;
        t = new Ex08<>(cap);
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
        }
        keys[i] = key;
        values[i] = value;
        N++;
    }

    public void delete(Key key) {
        if (key == null) return;
        if (isEmpty() || !contains(key)) throw new NoSuchElementException();
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (key.equals(keys[i])) {
                keys[i] = null;
                values[i] = null;
                N--;
            }
        }
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
        if (N > 0 && N <= M / 8) resize(M / 2);
    }

    public Value[] get(Key key) {
        if (key == null) throw new IllegalArgumentException();
        if (isEmpty()) throw new NoSuchElementException();
        Queue<Value> queue = new Queue<>();
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) {
                queue.enqueue(values[i]);
            }
        }

        if (queue.isEmpty()) return null;
        Value[] results = (Value[]) new Object[queue.size()];
        for (int i = 0; i <= queue.size(); i++) {
            results[i] = queue.dequeue();
        }
        System.out.println("st get : results = " + Arrays.toString(results));
        return results;
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

    @Override
    public String toString() {
        return "Keys:" + Arrays.toString(keys) + ";\nValues:" + Arrays.toString(values);
    }
}
