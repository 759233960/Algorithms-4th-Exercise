package code_review.chapter4_1;

public class Cycle<T extends Graph> {
    private boolean[] marked;
    private boolean hasCycle;

    public Cycle(T G) {
        marked = new boolean[G.V()];
        for (int s = 0; s < G.V(); s++)
            if (!marked[s])
                dfs(G, s, s);
    }

    public void dfs(T G, int v, int u) {
        marked[v] = true;
        for (int w : G.adj(v))
            if (!marked[w])
                dfs(G, w, v);
            else if (w != u)
                hasCycle = true;
    }

    public boolean hasCycle() {
        return hasCycle;
    }

}
