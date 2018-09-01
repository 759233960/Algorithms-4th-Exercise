package exercise.chapter4_4;

import edu.princeton.cs.algs4.StdIn;

/**
 * <套汇算法/>
 * 比如USD->CAD 1.005, USD->EUR 0.741, EUR->CAD 1.366, 从USD->EUR->CAD为0.746*1.366=1.012 > 1.005
 * 故抽象模型：
 * - 将货币转化为顶点，将汇率转化为加权有向边。问题即转为“寻找所有边（加权有向）的权重之和计算”
 * - 将任意权重之积 w1w2w3……变为-ln(w1)-ln(w2)-ln(w3)……（积转为负权重和）
 * - 从v->w，只要出现负权重环，既是一次套现获利的好机会！
 */
public class Arbitrage {
    public static void main(String[] args) {
        int V = StdIn.readInt();
        String[] name = new String[V];
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(V);
        for (int v = 0; v < V; v++) {
            name[v] = StdIn.readString();
            for (int w = 0; w < v; w++) {
                double rate = StdIn.readDouble();
                DirectedEdge edge = new DirectedEdge(v, w, -Math.log(rate));
                G.addEdge(edge);
            }
        }
        BellmanFordSP spt = new BellmanFordSP(G, 0);
        if (spt.hasNegativeCycle()) {
            double stake = 1000.0;
            for (DirectedEdge edge : spt.negativeCycle()) {
                System.out.printf("%10.5f %s\n", stake, name[edge.from()]);
                stake *= Math.exp(-edge.weight());
                System.out.printf("= %10.5f %s\n", stake, name[edge.to()]);
            }
        } else System.out.println("No arbitage opportunity!");
    }
}
