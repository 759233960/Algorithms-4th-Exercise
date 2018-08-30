package exercise.chapter4_4;

import exercise.chapter1_3.Stack;
import exercise.chapter4_2.Topological;

/**
 * 无环加权有向图最短路径算法
 * 使用拓扑排序组成的加权有向图结构进行计算, relax
 * <p>
 * 性能：
 * 时间：E+V，线性
 * <p>
 * 由于Topological性能是 E+V，并且按照拓扑结构进行对每个顶点进行relax，不会重复遍历顶点
 */
public class AcyclicSP {
    private DirectedEdge[] edgeTo;
    private double[] disTo;

    public AcyclicSP(EdgeWeightedDigraph G, int s) {
        edgeTo = new DirectedEdge[G.V()];
        disTo = new double[G.V()];
        for (int v = 0; v < G.V(); v++)
            disTo[v] = Double.POSITIVE_INFINITY;
        disTo[s] = 0.0;

        Topological top = new Topological(G);
        for (int v : top.order())
            relax(G, v);
    }

    private void relax(EdgeWeightedDigraph G, int v) {
        for (DirectedEdge edge : G.adj(v)) {
            int w = edge.to();
            if (disTo[w] > disTo[v] + edge.weight()) {
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
