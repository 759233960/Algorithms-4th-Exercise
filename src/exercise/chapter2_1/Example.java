package exercise.chapter2_1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by Yif on 6/9/2018.
 */
public class Example {

    public static void sort(Comparable[] a) {

    }

    //v<w
    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void show(Comparable[] a) {
        //单行中打印数组
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        System.out.println();
    }

    public static boolean isSorted(Comparable[] a) {
        //测试数组是否有序
        for (int i = 0; i < a.length; i++) {
            if (less(a[i], a[i - 1]))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] a = In.readStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
