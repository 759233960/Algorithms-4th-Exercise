package exercise.chapter4_2;

import exercise.chapter1_3.Queue;
import exercise.chapter1_3.Stack;

public class BreadthFirstDirectedPaths {
    private boolean[] marked;   //vertex marked
    private int[] edgeTo;       //last vertex in road
    private int[] distTo;

    public BreadthFirstDirectedPaths(Digraph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        distTo = new int[G.V()];
        bfs(G, s);
    }

    public BreadthFirstDirectedPaths(Digraph G, Iterable<Integer> source) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        distTo = new int[G.V()];
        bfs(G, source);
    }

    private void bfs(Digraph G, int s) {
        Queue<Integer> queue = new Queue<>();
        marked[s] = true;
        distTo[s] = 0;
        queue.enqueue(s);
        while (!queue.isEmpty()) {
            int v = queue.dequeue();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    distTo[w] = distTo[v] + 1;
                    edgeTo[w] = v;
                    marked[w] = true;
                    queue.enqueue(w);
                }
            }
        }
    }

    private void bfs(Digraph G, Iterable<Integer> source) {
        Queue<Integer> queue = new Queue<>();
        for (int s : source) {
            marked[s] = true;
            distTo[s] = 0;
            queue.enqueue(s);
        }
        while (!queue.isEmpty()) {
            int v = queue.dequeue();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    distTo[w] = distTo[v] + 1;
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

    public int distTo(int v) {
        return distTo[v];
    }

    public Iterable<Integer> pathTo(int s, int v) {
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<>();
        for (int x = v; x != s; x = edgeTo[x])
            path.push(x);
        path.push(s);
        return path;
    }
}
