package exercise.chapter3_5;

public class SparseVector {
    private HashSTint<Double> st;

    public SparseVector() {
        st = new HashSTint<>();
    }

    public int size() {
        return st.size();
    }

    public void put(int i, double x) {
        st.put(i, x);
    }

    public double get(int i) {
        if (!st.contains(i)) return 0.0;
        else return st.get(i);
    }

    public double dot(double[] that) {
        double sum = 0.0;
        for (int i : st.keys())
            sum += that[i] * get(i);
        return sum;
    }
}
