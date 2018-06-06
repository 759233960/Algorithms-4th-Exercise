package exercise.chapter1_5;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 一般而言，压缩路径的设计，已经是最优算法解。
 * 实际应用时，主要注意如何实现树族。
 */
public class WeightedQuickUnionUF {
    private int[] id;
    private int[] sz;
    private int count;

    private WeightedQuickUnionUF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            sz[i] = 1;
        }
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q))
                continue;
            uf.union(p, q);
            StdOut.println(p + "  " + q);
        }
        StdOut.println(uf.count() + "components");
    }

    private int count() {
        return count;
    }

    private boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    private int find(int p) {
        while (p != id[p]) p = id[p];
        return p;
    }

    private void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        if (sz[pRoot] < sz[qRoot]) {
            id[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        } else {
            id[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }
        count--;
    }

}
