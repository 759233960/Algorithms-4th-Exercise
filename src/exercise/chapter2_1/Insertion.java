package exercise.chapter2_1;

/**
 * Created by Yif on 6/9/2018.
 */
public class Insertion extends Example {
    public static void sort(Comparable[] a, int lo, int hi) {
        for (int i = lo; i < hi; i++) {
            for (int j = i; j > 0 && Example.less(a[j], a[j - 1]); j--) {
                Example.exch(a, j, j - 1);
                //将较大的元素向右移动代替交换，可以优化效率
            }
        }
    }

    public static void sort(String[] a, int lo, int hi, int d) {
        //从d个字符开始对a[lo]到a[hi]排序
        for (int i = lo; i < hi; i++)
            for (int j = i; j > lo && less(a[j], a[j - 1], d); j--)
                exch(a, j, j - 1);
    }

    private static boolean less(String v, String w, int d) {
        return v.substring(d).compareTo(w.substring(d)) < 0;
    }

    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && Example.less(a[j], a[j - 1]); j--) {
                Example.exch(a, j, j - 1);
                //将较大的元素向右移动代替交换，可以优化效率
            }
        }
    }

}
