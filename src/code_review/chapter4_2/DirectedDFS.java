package code_review.chapter4_2;

import code_review.chapter4_1.IDepthFirstSearch;
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

public class DirectedDFS implements IDepthFirstSearch<Digraph> {
    private boolean marked[];
    private int count;

    public DirectedDFS(Digraph G, int s) {
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    public DirectedDFS(Digraph G, Iterable<Integer> sources) {
        marked = new boolean[G.V()];
        for (int s : sources)
            if (!marked[s]) dfs(G, s);
    }

    public static void main(String[] args) {
        Digraph G = new Digraph(new In(args[0]));
        Bag<Integer> sources = new Bag<>();
        for (int i = 1; i < args.length; i++)
            sources.add(Integer.parseInt(args[i]));
        DirectedDFS reachable = new DirectedDFS(G, sources);
        for (int v = 0; v < G.V(); v++)
            if (reachable.marked(v)) System.out.print(v + " ");
        System.out.println();
    }

    public void dfs(Digraph G, int v) {
        count++;
        marked[v] = true;
        for (int w : G.adj(v))
            if (!marked[w]) dfs(G, w);
    }

    public boolean marked(int v) {
        return marked[v];
    }

    public int count() {
        return count;
    }
}
