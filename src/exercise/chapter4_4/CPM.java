package exercise.chapter4_4;

import edu.princeton.cs.algs4.StdIn;

public class CPM {
    public static void main(String[] args) {
        int N = StdIn.readInt();
        StdIn.readLine();
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(2 * N + 2);
        int s = N * 2, t = N * 2 + 1;//s起点，t终点，0~2N所有顶点
        for (int i = 0; i < N; i++) {
            String[] a = StdIn.readLine().split("\\s+");
            double duration = Double.parseDouble(a[0]);
            G.addEdge(new DirectedEdge(i, i + N, duration));
            G.addEdge(new DirectedEdge(s, i, 0.0));
            G.addEdge(new DirectedEdge(i + N, t, 0.0));
            for (int j = 1; j < a.length; j++) {
                int successor = Integer.parseInt(a[j]);
                G.addEdge(new DirectedEdge(i + N, successor, 0.0));
            }
        }
        AcyclicLP lp = new AcyclicLP(G, s);
        System.out.println("Start times:");
        for (int i = 0; i < N; i++)
            System.out.printf("%d: %5.1f\n", i, lp.distTo(i));
        System.out.printf("Finish time: %5.1f\n", lp.distTo(t));
    }
}
