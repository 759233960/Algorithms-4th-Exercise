package exercise.chapter4_4;

public class DirectedEdge implements Comparable<DirectedEdge> {
    private final int v;            //边的起点
    private final int w;            //边的终点
    private final double weight;    //边的权重

    public DirectedEdge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public double weight() {
        return weight;
    }

    public int from() {
        return v;
    }

    public int to() {
        return w;
    }

    public String toString() {
        return String.format("%d->%d .2%f", v, w, weight);
    }

    @Override
    public boolean equals(Object that) {
        if (that instanceof DirectedEdge)
            return ((DirectedEdge) that).from() == this.from()
                    && ((DirectedEdge) that).to() == this.to()
                    && compareTo((DirectedEdge) that) == 0;
        return false;
    }

    @Override
    public int compareTo(DirectedEdge that) {
        return Double.compare(this.weight(), that.weight());
    }
}
