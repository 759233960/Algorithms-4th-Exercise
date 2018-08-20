package exercise.chapter4_1;

import edu.princeton.cs.algs4.In;
import exercise.chapter1_3.Bag;

public class Graph {
    private final int V;        //num of vertex, 顶点的数目
    private int E;              //num of edge
    private Bag<Integer>[] adj; //邻接表, implement of Bag

    public Graph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<>();
        }
    }

    public Graph(In in) {
        this(in.readInt());     //read num of vertex, initialize the graph
        int E = in.readInt();   //read num of edge
        for (int i = 0; i < E; i++) {
            //add another edge
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    protected Graph clone() {
        Graph g = new Graph(V());
        for (int i = 0; i < E; i++) {
            int finalI = i;
            adj[i].forEach(value -> g.addEdge(finalI, value));
        }
        return g;
    }

    @Override
    public String toString() {
        StringBuffer s = new StringBuffer();
        for (int i = 0; i < E; i++) {
            adj[i].forEach(value -> s.append(" ").append(value));
            s.append("\n");
        }
        return s.toString();
    }
}
