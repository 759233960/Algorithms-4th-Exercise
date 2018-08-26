package exercise.chapter4_3;

import edu.princeton.cs.algs4.In;
import exercise.chapter1_3.Bag;

public class EdgeWeightGraph {
    private final int V;
    private int E;
    private Bag<Edge>[] adj;

    public EdgeWeightGraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Edge>[]) new Bag[V];
        for (int v = 0; v < V; v++)
            adj[v] = new Bag<>();
    }

    public EdgeWeightGraph(In in) {
        this(in.readInt());
        //TODO:
    }

    @Override
    public String toString() {
        //TODO:
        return super.toString();
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(Edge edge) {
        int v = edge.either();
        int w = edge.other(v);
        adj[v].add(edge);
        adj[w].add(edge);
        E++;
    }

    public Iterable<Edge> adj(int v) {
        return adj[v];
    }

    public Iterable<Edge> edges() {
        Bag<Edge> bag = new Bag<>();
        for (int v = 0; v < V; v++)
            for (Edge edge : adj[v])
                if (edge.other(v) > v) bag.add(edge);
        return bag;
    }
}
