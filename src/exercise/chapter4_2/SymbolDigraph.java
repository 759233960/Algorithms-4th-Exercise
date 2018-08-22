package exercise.chapter4_2;

import edu.princeton.cs.algs4.In;
import exercise.chapter3_5.ST;
import exercise.chapter4_1.Graph;

public class SymbolDigraph {
    private ST<String, Integer> st;                  //符号名String   ->  索引int
    private String[] keys;                           //索引int    ->  符号名String
    private Digraph G;                                 //用于管理邻接表，索引图中的顶点int

    public SymbolDigraph(String stream, String sp) {
        st = new ST<>();
        In in = new In(stream);                      //第一遍
        while (in.hasNextLine()) {                   // 构造索引st表
            String[] a = in.readLine().split(sp);

            for (int i = 0; i < a.length; i++)
                if (!st.contains(a[i]))
                    st.put(a[i], st.size());
        }
        keys = new String[st.size()];                // 构造反向索引keys

        for (String name : st.keys())
            keys[st.get(name)] = name;

        G = new Digraph(st.size());
        in = new In(stream);                         //第二遍
        while (in.hasNextLine()) {                   //构造图
            String[] a = in.readLine().split(sp);    //将每行的第一个顶点与该行的其他顶点相连
            int v = st.get(a[0]);
            for (int i = 0; i < a.length; i++)
                G.addEdge(v, st.get(a[i]));
        }
    }

    public boolean contains(String s) {
        return st.contains(s);
    }

    public int index(String s) {
        return st.get(s);
    }

    public String name(int v) {
        return keys[v];
    }

    public Digraph G() {
        return G;
    }
}
