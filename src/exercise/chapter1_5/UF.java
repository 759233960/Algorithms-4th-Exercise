package exercise.chapter1_5;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class UF {
    private int[] id;
    private int count;

    private UF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        UF uf = new UF(N);
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

//    /**
//     * quick-find
//     */
//    private int find(int p) {
//        return id[p];
//    }
//
//    private void union(int p, int q) {
//        int pID = find(p);
//        int qID = find(q);
//
//        if (pID == qID) {
//            return;
//        }
//        for (int i = 0; i < id.length; i++) {
//            if (id[i] == pID) id[i] = qID;
//        }
//        count--;
//    }

    /**
     * quick-union 树结构
     *
     * @param p
     * @return
     */
    private int find(int p) {
        //找出分量的名称,找出p的根节点pRoot
        while (p != id[p]) p = id[p];
        return p;
    }

    private void union(int p, int q) {
        //将p和q的根节点统一
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        id[pRoot] = qRoot;
        count--;
    }
}
