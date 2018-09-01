package exercise.chapter4_4;

import exercise.chapter1_3.Queue;
import exercise.chapter1_3.Stack;

/**
 * 一般加权有向图的最短路径
 * 可以处理权重为负的边
 * 性能：
 * 空间：V
 * 时间：EV
 * 放松E条边，重复V轮
 */
public class BellmanFordSP {
    private double[] distTo;                //从起点到某个顶点的路径长度
    private DirectedEdge[] edgeTo;          //从起点到某个顶点的最后一条边
    private boolean[] onQ;                  //该顶点是否存在于队列中
    private Queue<Integer> queue;           //正在被放松的顶点
    private int cost;                       //relax() 的调用次数
    private Iterable<DirectedEdge> cycle;   //edgeTo[] 中是否还有负权重环

    public BellmanFordSP(EdgeWeightedDigraph G, int s) {
        distTo = new double[G.V()];
        edgeTo = new DirectedEdge[G.V()];
        onQ = new boolean[G.V()];
        queue = new Queue<>();
        for (int v = 0; v < G.V(); v++)
            distTo[v] = Double.POSITIVE_INFINITY;
        distTo[s] = 0.0;
        onQ[s] = true;
        while (!queue.isEmpty() && !hasNegativeCycle()) {
            int v = queue.dequeue();
            onQ[v] = false;
            relax(G, v);
        }
    }

    private void relax(EdgeWeightedDigraph G, int v) {
        for (DirectedEdge edge : G.adj(v)) {
            int w = edge.to();
            if (distTo[w] > distTo[v] + edge.weight()) {
                distTo[w] = distTo[v] + edge.weight();
                edgeTo[w] = edge;
                if (!onQ[w]) {
                    queue.enqueue(w);
                    onQ[w] = true;
                }
            }
            if (cost++ % G.V() == 0)
                findNegativeCycle();
        }
    }

    public void findNegativeCycle() {
        int V = edgeTo.length;
        EdgeWeightedDigraph spt;
        spt = new EdgeWeightedDigraph(V);
        for (DirectedEdge edge : edgeTo)
            if (edge != null)
                spt.addEdge(edge);
        EdgeWeightedDirectedCycle finder = new EdgeWeightedDirectedCycle(spt);
        cycle = finder.cycle();
    }

    public Iterable<DirectedEdge> negativeCycle() {
        return cycle;
    }

    public boolean hasNegativeCycle() {
        return cycle != null;
    }

    public double distTo(int v) {
        checkVertex(v);
        return distTo[v];
    }

    public boolean hasPathTo(int v) {
        checkVertex(v);
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    public Iterable<DirectedEdge> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<DirectedEdge> path = new Stack<>();
        for (DirectedEdge edge = edgeTo[v]; edge != null; edge = edgeTo[edge.from()])
            path.push(edge);
        return path;
    }

    private void checkVertex(int v) {
        if (v < 0 || v >= distTo.length)
            throw new IllegalArgumentException("illegal vertex!!!");
    }
}
