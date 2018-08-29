package code_review.chapter4_2;

import code_review.chapter4_1.IDepthFirstSearch;
import exercise.chapter1_3.Stack;
import code_review.chapter4_1.Cycle;

public class DirectedCycle extends Cycle<Digraph> implements IDepthFirstSearch<Digraph> {
    private boolean[] marked;
    private int[] edgeTo;
    private Stack<Integer> cycle;   //有向环中的所有顶点（如果存在）
    private boolean[] onStack;      //递归调用的栈上的所有顶点

    public DirectedCycle(Digraph G) {
        super(G);
        onStack = new boolean[G.V()];
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        for (int v = 0; v < G.V(); v++)
            if (!marked[v])
                dfs(G, v);
    }

    public void dfs(Digraph G, int v) {
        onStack[v] = true;
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (hasCycle()) return;
            else if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            } else if (onStack[w]) {
                cycle = new Stack<>();
                for (int x = v; x != w; x = edgeTo[x])
                    cycle.push(x);
                cycle.push(w);
                cycle.push(v);
            }
        }
        onStack[v] = false;
    }

    public boolean hasCycle() {
        return cycle != null;
    }

    public Iterable<Integer> cycle() {
        return cycle;
    }
}
