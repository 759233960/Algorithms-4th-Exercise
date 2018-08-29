package code_review.chapter4_1;

public interface IBreadthFirstSearch<T extends Graph> {
    void bfs(T G, int v);
}
