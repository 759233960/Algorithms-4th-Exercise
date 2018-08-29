package code_review.chapter4_3;

import edu.princeton.cs.algs4.In;
import exercise.chapter1_3.Bag;

public class EdgeWeightedGraph <T extends Edge>{
    protected final int V;
    protected int E;
    protected Bag<T>[] adj;

    public EdgeWeightedGraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<T>[]) new Bag[V];
        for (int v = 0; v < V; v++)
            adj[v] = new Bag<>();
    }

    public EdgeWeightedGraph(In in) {
        this(in.readInt());
        int E = in.readInt();
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            double weight = in.readDouble();
            addEdge((T) new Edge(v, w, weight));
        }
    }

    public static void main(String[] args) {
        EdgeWeightedGraph graph = new EdgeWeightedGraph(13);
        graph.addEdge(new Edge(9, 10, 0.1));
        graph.addEdge(new Edge(9, 11, 0.3));
        graph.addEdge(new Edge(9, 12, 0.4));
        graph.addEdge(new Edge(11, 10, 0.02));
        System.out.println(graph);
        System.out.println("-----------------");
        System.out.println("has 10-11 0.02:" + graph.hasEdge(new Edge(10, 11, 0.02)));
        System.out.println("has 11-10 0.02:" + graph.hasEdge(new Edge(11, 10, 0.02)));
        System.out.println("has 10-9 0.1:" + graph.hasEdge(new Edge(10, 11, 0.1)));
        System.out.println("has 9-10 0.1:" + graph.hasEdge(new Edge(9, 10, 0.1)));
        System.out.println("has 12-10 0.4:" + graph.hasEdge(new Edge(12, 10, 0.4)));
        System.out.println("-----------------");
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V).append(" Vertex ;").append(E).append(" Edge");
        for (int v = 0; v < V; v++) {
            s.append("\n").append(v).append(":");
            for (Edge edge : adj[v])
                s.append("[").append(v).append("-").append(edge.other(v)).append(": ").append(edge.weight()).append("] ");
        }
        return s.toString();
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(T edge) {
        int v = edge.either();
        int w = edge.other(v);
        adj[v].add(edge);
        adj[w].add(edge);
        E++;
    }

    public Iterable<T> adj(int v) {
        return adj[v];
    }

    public Iterable<T> edges() {
        Bag<T> bag = new Bag<>();
        for (int v = 0; v < V; v++)
            for (T edge : adj[v])
                if (edge.other(v) > v) bag.add(edge);
        return bag;
    }

    public boolean hasEdge(T edge) {
        if (V() < 2) return false;
        if (edge.either() < 0 || edge.either() > V()) return false;
        int v = edge.either();
        int w = edge.other(v);
        for (T temp : adj[v]) {
            if (temp.equals(edge))
                return true;
        }
        return false;
    }
}
