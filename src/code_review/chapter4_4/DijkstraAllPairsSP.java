package code_review.chapter4_4;

/**
 * 性能：
 * 空间：  EVLogV
 * 时间：  EVLogV
 */
public class DijkstraAllPairsSP {
    private DijkstraSP[] all;

    public DijkstraAllPairsSP(EdgeWeightedDigraph G) {
        all = new DijkstraSP[G.V()];
        for (int v = 0; v < G.V(); v++)
            all[v] = new DijkstraSP(G, v);
    }

    public Iterable<DirectedEdge> path(int v, int w) {
        if (v < 0 || v > all.length) throw new IllegalArgumentException("vertex is illegal!");
        return all[v].pathTo(w);
    }

    public double dist(int s, int t) {
        if (s < 0 || s > all.length) throw new IllegalArgumentException("vertex is illegal!");
        return all[s].disTo(t);
    }
}
