package exercise.chapter2_3;

import edu.princeton.cs.algs4.StdRandom;
import exercise.chapter2_1.Example;

public class Quick3way extends Example {
    public static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
//        if (hi <= lo + 10) {
//            Insertion.sort(a, lo, hi);
//            return;
//        }
        int lt = lo, i = lo + 1, gt = hi;
        Comparable v = a[lo];
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) exch(a, lt++, i++);
            else if (cmp > 0) exch(a, i, gt--);
            else i++;
        }
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }

    @Override
    public void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }
}
