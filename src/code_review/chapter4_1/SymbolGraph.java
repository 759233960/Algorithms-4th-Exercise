package code_review.chapter4_1;

import edu.princeton.cs.algs4.In;
import exercise.chapter3_5.ST;

public class SymbolGraph<T extends Graph> {
    private ST<String, Integer> st;                  //符号名String   ->  索引int
    private String[] keys;                           //索引int    ->  符号名String
    private T G;                                 //用于管理邻接表，索引图中的顶点int

    public SymbolGraph(String stream, String sp) {
        st = new ST<>();
        In in = new In(stream);                      //第一遍
        while (in.hasNextLine()) {                   // 构造索引st表
            String[] a = in.readLine().split(sp);

            for (String s : a)
                if (!st.contains(s))
                    st.put(s, st.size());
        }
        keys = new String[st.size()];                // 构造反向索引keys

        for (String name : st.keys())
            keys[st.get(name)] = name;

        G = (T) new Graph(st.size());
        in = new In(stream);                         //第二遍
        while (in.hasNextLine()) {                   //构造图
            String[] a = in.readLine().split(sp);    //将每行的第一个顶点与该行的其他顶点相连
            int v = st.get(a[0]);
            for (String s : a) G.addEdge(v, st.get(s));
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

    public T G() {
        return G;
    }
}
