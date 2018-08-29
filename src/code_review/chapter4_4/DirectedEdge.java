package code_review.chapter4_4;

import code_review.chapter4_3.Edge;

/**
 * 加权有向边
 */
public class DirectedEdge extends Edge {
    public DirectedEdge(int v, int w, double weight) {
        super(v, w, weight);
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
}
