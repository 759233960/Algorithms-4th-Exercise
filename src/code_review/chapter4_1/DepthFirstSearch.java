package code_review.chapter4_1;

import exercise.chapter1_3.Stack;

public class DepthFirstSearch<T extends Graph> implements IDepthFirstSearch<T> {
    private final int s;
    private int count;
    private boolean[] marked;
    private int[] edgeTo;

    public DepthFirstSearch(T G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        dfs(G, s);
    }

    public void dfs(T G, int V) {
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

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<>();
        for (int x = v; x != s; x = edgeTo[x])
            path.push(x);
        path.push(s);
        return path;
    }

    public int count() {
        return count;
    }
}
