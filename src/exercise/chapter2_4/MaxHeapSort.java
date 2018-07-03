package exercise.chapter2_4;

public class MaxHeapSort {//max 0 to min N

    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int k = N / 2; k >= 1; k--) {
            sink(a, k, N);
        }
        while (N > 1) {
            exch(a, 1, N--);//exchange max element into last of array
            sink(a, 1, N);//restore struct of max-heap
        }
    }

    public static void sink(Comparable[] a, int k, int N) {
        while (k * 2 <= N) {
            int j = k * 2;
            if (less(a[j], a[j + 1])) j++;
            if (less(a[j], a[k])) break;
            exch(a, k, j);
            k = j;
        }
    }

    public static void swim(Comparable[] a, int k, int N) {
        while (less(k / 2, k)) {
            if (k / 2 <= 0) return;
            exch(a, k / 2, k);
            k = k / 2;
        }
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static boolean less(Comparable i, Comparable j) {
        return i.compareTo(j) < 0;
    }
}
