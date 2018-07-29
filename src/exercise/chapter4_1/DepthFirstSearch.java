package exercise.chapter4_1;

import exercise.chapter1_3.Stack;

public class DepthFirstSearch {
    private final int s;
    private boolean[] marked;
    private int count;
    private int[] edgeTo;

    public DepthFirstSearch(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        dfs(G, s);
    }

    private void dfs(Graph G, int V) {
        marked[V] = true;
        count++;
        for (int w : G.adj(V)) {
            if (!marked[w]) {
                edgeTo[w] = V;
                dfs(G, w);
            }
        }
    }

    public boolean hasPathTo(int w) {
        return marked[w];
    }

    public int count() {
        return count;
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<>();
        for (int x = v; x != s; x = edgeTo[x])
            path.push(x);
        path.push(s);
        return path;
    }
}
