package exercise.chapter2_1;

/**
 * Created by Yif on 6/10/2018.
 * Shell排序，是一种插入排序的优化算法。
 * O(MAX) = N^(3/2)
 * O = N^(1/5)
 */
public class Shell extends Example {
    public void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N / 3)
            h = 3 * h + 1;
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && Example.less(a[j], a[j - h]); j -= h) {
                    Example.exch(a, j, j - h);
                }
            }
            h = h / 3;
        }

    }
}
