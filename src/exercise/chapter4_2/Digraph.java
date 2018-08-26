package exercise.chapter4_2;

import edu.princeton.cs.algs4.In;
import exercise.chapter1_3.Bag;

public class Digraph {
    private final int V;
    private int E;
    private Bag<Integer>[] adj;

    public Digraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++)
            adj[v] = new Bag<>();
    }

    public Digraph(In in) {
        this(in.readInt());
        int E = in.readInt();
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }

    public static void main(String[] args) {
        Digraph graph = new Digraph(13);
        graph.addEdge(9, 10);
        graph.addEdge(9, 11);
        graph.addEdge(12, 11);
        graph.addEdge(9, 12);
        System.out.println(graph);
        System.out.println("-----------------");
        System.out.println("has 10-11:" + graph.hasEdge(10, 11));
        System.out.println("has 11-10:" + graph.hasEdge(11, 10));
        System.out.println("has 10-9:" + graph.hasEdge(10, 9));
        System.out.println("has 9-11:" + graph.hasEdge(9, 10));
        System.out.println("has 12-10:" + graph.hasEdge(12, 10));
        System.out.println("-----------------");
        System.out.println("clone:");

        System.out.println(graph.clone());
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(int v, int w) {
        if (hasEdge(v, w)) throw new IllegalArgumentException("Not support parallel edge");
        if (v == w) throw new IllegalArgumentException("Not support self-loop");
        adj[v].add(w);
        E++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public Digraph reverse() {
        Digraph R = new Digraph(V);
        for (int v = 0; v < V; v++)
            for (int w : adj[v])
                R.addEdge(w, v);
        return R;
    }

    public boolean hasEdge(int v, int w) {
        if (V() < 2) return false;
        if (v < 0 || v > V()) return false;
        return adj[v].contains(w);
    }

    public Digraph clone() {
        Digraph graph = new Digraph(V());
        for (int i = 0; i < graph.V(); i++) {
            for (int s : adj[i]) {
                if (!graph.hasEdge(i, s))
                    graph.addEdge(i, s);
            }
        }
        return graph;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V).append(" Vertex ;").append(E).append(" Edge");
        for (int v = 0; v < V; v++) {
            s.append("\n").append(v).append(":");
            for (int w : adj[v])
                s.append(w).append(" ");
        }
        return s.toString();
    }
}
