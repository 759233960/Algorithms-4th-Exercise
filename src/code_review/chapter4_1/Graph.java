package code_review.chapter4_1;

import edu.princeton.cs.algs4.In;
import exercise.chapter1_3.Bag;

public class Graph {
    protected final int V;        //num of vertex, 顶点的数目
    protected int E;              //num of edge
    protected Bag<Integer>[] adj; //邻接表, implement of Bag

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

    public Graph(String stream) {
        In in = new In(stream);
        this.V = in.readInt();
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<>();
        }
        int E = in.readInt();
        for (int i = 0; i < E; i++) {
            if (!in.hasNextChar()) return;
            String[] s = in.readLine().trim().split(" ");
            for (int j = 0; j < s.length; j++) {
                int value = Integer.valueOf(s[j]);
                if (hasEdge(i, value))
                    addEdge(i, value);
            }
        }
    }


    public static void main(String[] args) {
        Graph graph = new Graph(13);
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
        if (v > V || v < 0 || w > V || w < 0) throw new IllegalArgumentException();
        if (v == w) throw new IllegalArgumentException("Don't allow self-loop!");
        if (adj[v].contains(w) || adj[w].contains(v)) throw new IllegalArgumentException("Don't allow parallel-edge!");
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    public boolean hasEdge(int v, int w) {
        if (V() < 2) return false;
        if (v < 0 || v > V()) return false;
        return adj[v].contains(w);
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public Graph clone() {
        Graph g = new Graph(V());
        for (int i = 0; i < V; i++) {
            for (Integer value : adj[i]) {
                if (!g.hasEdge(i, value))
                    g.addEdge(i, value);
            }
        }
        return g;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < V; i++) {
            s.append(i).append(":");
            for (Object o : adj[i]) {
                s.append(" ").append(o);
            }
            s.append("\n");
        }
        return s.toString();
    }
}


