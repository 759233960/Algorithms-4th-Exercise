package code_review.chapter4_3;

import edu.princeton.cs.algs4.MinPQ;
import exercise.chapter1_3.Queue;

/**
 * 性能：
 * 空间   E
 * 时间   ElogE
 */
public class LazyPrimMST {
    private boolean[] marked;   //最小生成树的顶点
    private Queue<Edge> mst;    //最小生成树的边
    private MinPQ<Edge> pq;     //横切边（包括失效的边）,MinPQ为优先队列

    public LazyPrimMST(EdgeWeightedGraph<Edge> G) {
        pq = new MinPQ<>();
        marked = new boolean[G.V()];
        mst = new Queue<>();

        visit(G, 0);
        while (!pq.isEmpty()) {
            Edge e = pq.delMin();                   //从pq中得到权重最小的边
            int v = e.either(), w = e.other(v);
            if (marked[v] && marked[w]) continue;   //跳过失效的边
            mst.enqueue(e);                         //将边添加到树中
            if (!marked[v]) visit(G, v);            //将顶点添加到树中
            if (!marked[w]) visit(G, w);
        }
    }


    private void visit(EdgeWeightedGraph<Edge> G, int v) {
        //标记顶点v并将所有连接v和未被标记的边加入pq
        marked[v] = true;
        for (Edge e : G.adj(v))
            if (!marked[e.other(v)]) pq.insert(e);
    }

    public Iterable<Edge> edges() {
        return mst;
    }

    public double weight() {
        double weight = 0.0;
        for (Edge e : edges())
            weight += e.weight();
        return weight;
    }
}
