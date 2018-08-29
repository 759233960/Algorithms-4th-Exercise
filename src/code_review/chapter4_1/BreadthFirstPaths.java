package code_review.chapter4_1;

import exercise.chapter1_3.Queue;
import exercise.chapter1_3.Stack;

public class BreadthFirstPaths<T extends Graph> implements IBreadthFirstSearch<T> {
    private final int s;        //startup
    private boolean[] marked;   //vertex marked
    private int[] edgeTo;       //last vertex in road

    public BreadthFirstPaths(T G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        bfs(G, s);
    }

    public BreadthFirstPaths(T G, Iterable<Integer> source) {
        //Do Nothing
        s = 0;
    }

    public void bfs(T G, int s) {
        Queue<Integer> queue = new Queue<>();
        marked[s] = true;
        queue.enqueue(s);
        while (!queue.isEmpty()) {
            int v = queue.dequeue();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    marked[w] = true;
                    queue.enqueue(w);
                }
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<>();
        for (int x = v; x != s; x = edgeTo[x])
            path.push(x);
        path.push(s);
        return path;
    }

    public int distTo(int v) {
        //0~v distance
        int dis = 0;
        if (!hasPathTo(v)) return dis;
        for (int x = v; x != s; x = edgeTo[x])
            dis++;
        return dis;
    }
}
