package exercise.chapter4_3;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import exercise.chapter1_3.Queue;

/**
 * 性能：
 * 空间   E
 * 时间   ElogE
 */
public class KruskalMST {
    private Queue<Edge> mst;
    private double weight;

    public KruskalMST(EdgeWeightGraph G) {
        weight = 0.0;
        mst = new Queue<>();
        MinPQ<Edge> pq = new MinPQ<>();
        for (Edge e : G.edges()) pq.insert(e);
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(G.V());
        while (!pq.isEmpty() && mst.size() < G.V() - 1) {
            Edge e = pq.delMin();
            int v = e.either(), w = e.other(v);
            if (uf.connected(v, w)) continue;
            uf.union(v, w);
            mst.enqueue(e);
            weight += e.weight();
        }
    }

    public Iterable<Edge> edges() {
        return mst;
    }

    public double weight() {
        return weight;
    }
}
