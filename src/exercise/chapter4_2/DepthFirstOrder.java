package exercise.chapter4_2;

import exercise.chapter1_3.Queue;
import exercise.chapter1_3.Stack;
import exercise.chapter4_4.DirectedEdge;
import exercise.chapter4_4.EdgeWeightedDigraph;

public class DepthFirstOrder {
    private boolean[] marked;
    private Queue<Integer> pre;         //所有顶点的前序排列
    private Queue<Integer> post;        //所有顶点的后序排列
    private Stack<Integer> reversePost; //所有顶点的逆后序排列(stack)

    public DepthFirstOrder(Digraph G) {
        pre = new Queue<>();
        post = new Queue<>();
        reversePost = new Stack<>();
        marked = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++)
            if (!marked[v])
                dfs(G, v);
    }

    public DepthFirstOrder(EdgeWeightedDigraph G) {
        pre = new Queue<>();
        post = new Queue<>();
        reversePost = new Stack<>();
        marked = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++)
            if (!marked[v])
                dfs(G, v);
    }

    private void dfs(Digraph G, int v) {
        pre.enqueue(v);

        marked[v] = true;
        for (int w : G.adj(v))
            if (!marked[w])
                dfs(G, w);

        post.enqueue(v);
        reversePost.push(v);
    }

    private void dfs(EdgeWeightedDigraph G, int v) {
        pre.enqueue(v);

        marked[v] = true;
        for (DirectedEdge edge : G.adj(v)) {
            int w = edge.to();
            if (!marked[w])
                dfs(G, w);
        }
        post.enqueue(v);
        reversePost.push(v);
    }

    public Iterable<Integer> pre() {
        return pre;
    }

    public Iterable<Integer> post() {
        return post;
    }

    public Iterable<Integer> reversePost() {
        return reversePost;
    }
}
