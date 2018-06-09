package exercise.chapter2_1;

/**
 * Created by Yif on 6/9/2018.
 */
public class Insertion {
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && Example.less(a[j], a[j - 1]); j--) {
                Example.exch(a, j, j - 1);
                //将较大的元素向右移动代替交换，可以优化效率
            }
        }
    }
}
