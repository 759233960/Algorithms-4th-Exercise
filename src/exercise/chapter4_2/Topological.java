package exercise.chapter4_2;

import exercise.chapter4_4.EdgeWeightedDigraph;
import exercise.chapter4_4.EdgeWeightedDirectedCycle;

import java.util.Iterator;

public class Topological {
    private Iterable<Integer> order;        //顶点的拓扑排序,为所有顶点的逆后序排列。

    public Topological(Digraph G) {
        DirectedCycle cycleFinder = new DirectedCycle(G);
        if (!cycleFinder.hasCycle()) {
            DepthFirstOrder dfs = new DepthFirstOrder(G);
            order = dfs.reversePost();
        }
    }

    public Topological(EdgeWeightedDigraph G) {
        EdgeWeightedDirectedCycle find = new EdgeWeightedDirectedCycle(G);
        if (!find.hasCycle()) {
            DepthFirstOrder dfs = new DepthFirstOrder(G);
            order = dfs.reversePost();
        }
    }

    public Topological(EdgeWeightedDigraph G, int s) {
        EdgeWeightedDirectedCycle find = new EdgeWeightedDirectedCycle(G, s);
        if (!find.hasCycle()) {
            DepthFirstOrder dfs = new DepthFirstOrder(G);
            order = dfs.reversePost();
        }
    }

    public static void main(String[] args) {
        String fileName = args[0];
        String separator = args[1];
        SymbolDigraph sg = new SymbolDigraph(fileName, separator);

        Topological top = new Topological(sg.G());
        for (int v : top.order())
            System.out.println(sg.name(v));
    }

    public Iterable<Integer> order() {
        return order;
    }

    public boolean isDAG() {
        return order != null;
    }

    public boolean isTopOrder(Iterable<Integer> stack) {
        if (!isDAG()) return false;
        Iterator<Integer> it = order.iterator();
        for (int w : stack)
            if (it.hasNext()) {
                if (it.next() != w)
                    return false;
            } else {
                return false;
            }
        return true;
    }
}
