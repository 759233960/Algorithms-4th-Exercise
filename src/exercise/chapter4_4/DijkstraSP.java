package exercise.chapter4_4;

import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.Stack;

import java.util.NoSuchElementException;

/**
 * 可以处理环,可以求最小环
 * 相当于Prim算法的即时实现版本：PrimMST.java
 * 参照Prim算法，稍作变种即可实现延迟版
 * 性能：
 * 空间   V
 * 时间   ElogV
 */
public class DijkstraSP {
    private DirectedEdge[] edgeTo;
    private double[] disTo;
    private IndexMinPQ<Double> pq;

    public DijkstraSP(EdgeWeightedDigraph G, int s) {
        edgeTo = new DirectedEdge[G.V()];
        disTo = new double[G.V()];
        pq = new IndexMinPQ<>(G.V());
        for (int v = 0; v < G.V(); v++)
            disTo[v] = Double.POSITIVE_INFINITY;
        disTo[s] = 0.0;
        pq.insert(s, disTo[s]);
        while (!pq.isEmpty())
            relax(G, pq.delMin());
    }

    private void relax(EdgeWeightedDigraph G, int v) {
        if (v < 0 || v > disTo.length) throw new NoSuchElementException("vertex is illegal!");
        for (DirectedEdge edge : G.adj(v)) {
            int w = edge.to();
            if (disTo[w] > disTo[v] + edge.weight()) {
                disTo[w] = disTo[v] + edge.weight();
                edgeTo[w] = edge;
                if (pq.contains(w)) pq.changeKey(w, disTo[w]);
                else pq.insert(w, disTo[w]);
            }
        }
    }

    public double disTo(int v) {
        if (v < 0 || v > disTo.length) throw new IllegalArgumentException("vertex is illegal!");
        return disTo[v];
    }

    public boolean hasPathTo(int v) {
        if (v < 0 || v > disTo.length) return false;
        return disTo[v] < Double.POSITIVE_INFINITY;
    }

    public Iterable<DirectedEdge> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<DirectedEdge> path = new Stack<>();
        for (DirectedEdge edge = edgeTo[v]; edge != null; edge = edgeTo[edge.from()])
            path.push(edge);
        return path;
    }

}
