package exercise.chapter2_1;

/**
 * Created by Yif on 6/10/2018.
 * 自底向上的归并数组
 * 比较次数：O = 1/2NlgN ~ NlgN
 * 访问数组次数：最多 6NlgN 次
 * 适合用于链表结构的数据
 */
public class MergeBU extends Example {
    private static Comparable[] aux;

    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        aux = new Comparable[N];
        for (int sz = 1; sz < N; sz = sz + sz) {
            for (int lo = 0; lo < N - sz; lo += sz + sz) {
                merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
            }
        }
    }

}
