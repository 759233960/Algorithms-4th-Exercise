package code_review.chapter4_2;

import exercise.chapter1_3.Bag;

public class Degrees {
    private Digraph G;

    /**
     * 有向图构建映射
     *
     * @param G 有向图
     */
    public Degrees(Digraph G) {
        this.G = G;
    }

    /**
     * @param v 顶点
     * @return 顶点的入度，指向该顶点的边的总数
     */
    public int indegree(int v) {
        int i = 0;
        for (int w : G.reverse().adj(v))
            i++;
        return i;
    }

    /**
     * @param v 顶点
     * @return 顶点的出度，由该顶点指向的边的总数
     */
    public int outdegree(int v) {
        int i = 0;
        for (int w : G.adj(v))
            i++;
        return i;
    }

    /**
     * @return 起点集合，入度为0
     */
    public Iterable<Integer> sources() {
        Bag<Integer> bag = new Bag<>();
        for (int i = 0; i < G.V(); i++)
            if (indegree(i) == 0 && !bag.contains(i))
                bag.add(i);
        return bag;
    }

    /**
     * @return 终点集合，出度为0
     */
    public Iterable<Integer> sinks() {
        Bag<Integer> bag = new Bag<>();
        for (int i = 0; i < G.V(); i++)
            if (outdegree(i) == 0 && !bag.contains(i))
                bag.add(i);
        return bag;
    }

    /**
     * 每个顶点出度均为1
     *
     * @return 是否是映射表
     */
    public boolean isMap() {
        for (int i = 0; i < G.V(); i++)
            if (outdegree(i) != 1)
                return false;
        return true;
    }
}
