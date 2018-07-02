package exercise.chapter2_3;

import edu.princeton.cs.algs4.StdRandom;
import exercise.chapter2_1.Example;

public class Quick extends Example {
    private static final int M = 10; // 5~15 ,小数组的大小

    public static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
//        if (hi <= lo + M) {
//            Insertion.sort(a, lo, hi);
//            return;//小数组使用插入排序会更快
//        }
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        //将数组切分为a[lo..i-1] <= a[i] <= a[i+1..hi]
        int i = lo, j = hi + 1;
        Comparable v = a[lo];
        do {
            //扫描左右，检查扫描是否结束并交换元素
            while (less(a[++i], v))
                if (i == hi)
                    break;
            while (less(v, a[--j]))
                if (j == lo)//多余的判断，自己不可能比自己小。
                    break;
            exch(a, i, j);
        } while (i < j);
        exch(a, lo, j);
        return j;
    }

    @Override
    public void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }
}
