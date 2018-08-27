package exercise.chapter4_3;

import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.Queue;

public class PrimMST {
    private Edge[] edgeTo;          //距离树最近的边
    private double[] distTo;        //distTo[w]=edgTo[w].weight()
    private boolean[] marked;       //如果v在树中，则为true
    private IndexMinPQ<Double> pq;  //有效的横切边

    public PrimMST(EdgeWeightGraph G) {
        edgeTo = new Edge[G.V()];
        distTo = new double[G.V()];
        marked = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++)
            distTo[v] = Double.POSITIVE_INFINITY;//无限大
        pq = new IndexMinPQ<>(G.V());

        distTo[0] = 0.0;
        pq.insert(0, 0.0);   //用顶点0、权重0初始化pq
        while (!pq.isEmpty())
            visit(G, pq.delMin());
    }

    private void visit(EdgeWeightGraph G, int v) {
        //将顶点v添加到树中，并更新数据
        marked[v] = true;
        for (Edge e : G.adj(v)) {
            int w = e.other(v);

            if (marked[w]) continue;    //v-w失效
            if (e.weight() < distTo[w]) {
                //连接w和树的最佳边变为e，更新数据
                edgeTo[w] = e;
                distTo[w] = e.weight();
                if (pq.contains(w)) pq.changeKey(w, distTo[w]);
                else pq.insert(w, distTo[w]);
            }
        }
    }

    public Iterable<Edge> edges() {
        Queue<Edge> edges = new Queue<>();
        for (Edge anEdgeTo : edgeTo)
            if (anEdgeTo != null)
                edges.enqueue(anEdgeTo);
        return edges;
    }

    public double weight() {
        double weight = 0.0;
        for (Edge e : edges())
            weight += e.weight();
        return weight;
    }

}
