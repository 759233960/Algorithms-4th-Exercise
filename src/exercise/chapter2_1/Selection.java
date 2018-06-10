package exercise.chapter2_1;

/**
 * Created by Yif on 6/9/2018.
 */
public class Selection extends Example {
    public void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++)
                if (Example.less(a[j], a[min]))
                    min = j;
            Example.exch(a, i, min);
        }
    }
}
