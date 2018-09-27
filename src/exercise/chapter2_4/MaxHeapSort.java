package exercise.chapter2_4;

public class MaxHeapSort {//max 0 to min N

    public static void sort(Comparable[] a) {
        int N = a.length - 1;
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
            if (j < N && less(a[j], a[j + 1])) j++;
            if (!less(a[k], a[j])) break;
            exch(a, k, j);
            k = j;
        }
    }

    public static void swim(Comparable[] a, int k, int N) {
        while (k > 1 && less(a[k / 2], a[k])) {
            exch(a, k, k / 2);
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
