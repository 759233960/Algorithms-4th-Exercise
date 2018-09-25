package other.summary;

import java.util.Arrays;

public class HeapSort {

    static void heapify(Comparable[] a, int k) {
        int largest = k;
        int child = k << 1;
        if (child + 1 < a.length && a[child + 1].compareTo(a[child]) > 0)
            child++;
        if (child < a.length && a[child].compareTo(a[largest]) > 0)
            largest = child;
        if (largest != k) {
            exchange(a, k, largest);
            heapify(a, largest);
        }
    }

    static void exchange(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    static void sink(Comparable[] a, int k) {
        while ((k << 1) <= a.length) {
            int child = k << 1;
            if (child + 1 < a.length && a[child + 1].compareTo(a[child]) > 0)
                child++;
            if (child < a.length && a[child].compareTo(a[k]) > 0) {
                exchange(a, k, child);
                k = child;
            }
        }
    }

    static void swim(Comparable[] a, int k) {
        while (k > 1 && a[k].compareTo(a[k >>> 1]) > 0) {
            exchange(a, k >>> 1, k);
            k = k >>> 1;
        }
    }

    public static void main(String[] args) {
        Integer[] a = {1, 2, 4, 5, 6, 8, 9};
        System.out.println(Arrays.toString(a));

        int k = a.length;
        for (k = k >>> 1; k >= 0; k--) {
            heapify(a, k);
            System.out.println(Arrays.toString(a));
        }
    }
}
