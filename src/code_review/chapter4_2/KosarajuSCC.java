package code_review.chapter4_2;

import code_review.chapter4_1.CC;

public class KosarajuSCC extends CC<Digraph> {
    private boolean[] marked;
    private int[] id;
    private int count;

    public KosarajuSCC(Digraph G) {
        super(G);
        marked = new boolean[G.V()];
        id = new int[G.V()];
        DepthFirstOrder order = new DepthFirstOrder(G);
        for (int s : order.reversePost()) {
            if (!marked[s]) {
                dfs(G, s);
                count++;
            }
        }
    }

    public void dfs(Digraph G, int v) {
        marked[v] = true;
        id[v] = count;
        for (int w : G.adj(v))
            if (!marked[w])
                dfs(G, w);
    }

    public boolean connected(int v, int w) {
        return id[v] == id[w];
    }

    public boolean stronglyConnected(int v,int w){
        return connected(v,w);
    }

    public int id(int v) {
        return id[v];
    }

    public int count() {
        return count;
    }
}
