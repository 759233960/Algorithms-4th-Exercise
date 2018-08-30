package exercise.chapter4_4;

import edu.princeton.cs.algs4.IndexMinPQ;
import exercise.chapter1_3.Stack;

public class EdgeWeightedDirectedCycle {
    private boolean[] marked;
    private DirectedEdge[] edgeTo;
    private Stack<DirectedEdge> cycle;
    private boolean[] onStack;

    //取代marked，参考Prim/Dijkstra算法
    private double[] distTo;
    private IndexMinPQ<Double> pq;

    public EdgeWeightedDirectedCycle(EdgeWeightedDigraph G) {
        marked = new boolean[G.V()];
        edgeTo = new DirectedEdge[G.V()];
        onStack = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++)
            if (!marked[v])
                dfs(G, v);
    }

    public EdgeWeightedDirectedCycle(EdgeWeightedDigraph G, int s) {
        pq = new IndexMinPQ<>(G.V());
        distTo = new double[G.V()];
        for (int v = 0; v < G.V(); v++)
            distTo[v] = Double.POSITIVE_INFINITY;
        distTo[s] = 0.0;
        pq.insert(s, 0.0);
        while (!pq.isEmpty())
            relax(G, pq.delMin());
    }

    private void relax(EdgeWeightedDigraph G, int v) {
        for (DirectedEdge edge : G.adj(v)) {
            int w = edge.to();
            if (hasCycle()) return;
            if (distTo[w] > distTo[v] + edge.weight()) {
                distTo[w] = distTo[v] + edge.weight();
                edgeTo[w] = edge;
                if (pq.contains(w)) {
                    pq.changeKey(w, distTo[w]);
                    //has-cycle!
                    cycle = new Stack<>();
                    for (DirectedEdge e = edge; e.from() != w; e = edgeTo[w])
                        cycle.push(e);
                    cycle.push(edge);
                    return;
                } else pq.insert(w, distTo[w]);
            }
        }
    }

    private void dfs(EdgeWeightedDigraph G, int v) {
        marked[v] = true;
        onStack[v] = true;
        for (DirectedEdge edge : G.adj(v)) {
            int w = edge.to();
            if (hasCycle()) return;
            if (!marked[w]) {
                edgeTo[w] = edge;
                dfs(G, w);
            } else if (onStack[w]) {
                cycle = new Stack<>();
                for (DirectedEdge e = edge; e.from() != w; e = edgeTo[e.from()])
                    cycle.push(e);
                cycle.push(edge);
                return;
            }
        }
        onStack[v] = false;
    }

    public boolean hasCycle() {
        return cycle != null;
    }

    public Iterable<DirectedEdge> cycle() {
        return cycle;
    }
}
