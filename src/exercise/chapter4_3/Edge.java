package exercise.chapter4_3;

public class Edge implements Comparable<Edge> {

    private final int v;            //顶点之一
    private final int w;            //另一个顶点
    private final double weight;    //边的权重

    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public double weight() {
        return weight;
    }

    public int either() {
        return v;
    }

    public int other(int vertex) {
        if (vertex == v) return w;
        else if (vertex == w) return v;
        else throw new RuntimeException("Inconsistent edge");
    }

    @Override
    public int compareTo(Edge that) {
        return Double.compare(this.weight(), that.weight());
    }

    @Override
    public String toString() {
        return String.format("v:%d - w:%d, weight:%.2f", v, w, weight);
    }
}
