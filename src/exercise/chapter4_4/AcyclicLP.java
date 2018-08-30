package exercise.chapter4_4;

import exercise.chapter1_3.Stack;
import exercise.chapter4_2.Topological;

/**
 * <无环有向图最长路径算法>
 * {@link AcyclicLP}
 * 1.将所有边clone得到副本，再将副本的权重取相反数，即可。
 * 2.将{@code double[] distTo[]}初始赋值变为 {@code Double.NEGATIVE_INFINITY}，并改变relax()中判断不等式的方向，即可。
 * </无环有向图最长路径算法>
 */
public class AcyclicLP {
    private DirectedEdge[] edgeTo;
    private double[] disTo;

    public AcyclicLP(EdgeWeightedDigraph G, int s) {
        edgeTo = new DirectedEdge[G.V()];
        disTo = new double[G.V()];
        for (int v = 0; v < G.V(); v++)
            disTo[v] = Double.NEGATIVE_INFINITY;
        disTo[s] = 0.0;

        Topological top = new Topological(G);
        for (int v : top.order())
            relax(G, v);
    }

    private void relax(EdgeWeightedDigraph G, int v) {
        for (DirectedEdge edge : G.adj(v)) {
            int w = edge.to();
            if (disTo[w] < disTo[v] + edge.weight()) {
                disTo[w] = disTo[v] + edge.weight();
                edgeTo[w] = edge;
            }
        }
    }

    public double distTo(int v) {
        checkVertex(v);
        return disTo[v];
    }

    public boolean hasPathTo(int v) {
        checkVertex(v);
        return disTo[v] != Double.POSITIVE_INFINITY;
    }

    public Iterable<DirectedEdge> pathTo(int v) {
        checkVertex(v);
        if (!hasPathTo(v)) return null;
        Stack<DirectedEdge> path = new Stack<>();
        for (DirectedEdge edge = edgeTo[v]; edge != null; edge = edgeTo[edge.from()])
            path.push(edge);
        return path;
    }

    private void checkVertex(int v) {
        if (v < 0 || v >= disTo.length)
            throw new IllegalArgumentException("illegal vertex!!!");
    }
}
