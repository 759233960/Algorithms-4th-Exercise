package other.summary;

abstract class BaseSort {
    public abstract void sort(Comparable[] a);

    boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    void exchange(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i - 1])) return false;
        return true;
    }
}

class SelectionSort extends BaseSort {

    @Override
    public void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++)
                if (less(a[j], a[min])) min = j;
            exchange(a, i, min);
        }
    }
}

class InsertionSort extends BaseSort {

    @Override
    public void sort(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--)
                exchange(a, j, j - 1);
    }
}

class ShellSort extends BaseSort {

    @Override
    public void sort(Comparable[] a) {
        int h = 1;
        while (h < a.length / 3) h = h * 3 + 1;
        while (h >= 1) {
            for (int i = 1; i < a.length; i++)
                for (int j = i; j > h && less(a[j], a[j - h]); j -= h)
                    exchange(a, j, j - h);
            h = h / 3;
        }
    }
}

abstract class MergeSort extends BaseSort {
    Comparable[] aux;

    void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        for (int k = 0; k < a.length; k++)
            aux[k] = a[k];
        for (int k = 0; k < hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }
}

class MergeUBSort extends MergeSort {

    @Override
    public void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    private void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) return;
        int mid = (lo + hi) >>> 1;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }
}

class MergeBUSort extends MergeSort {

    @Override
    public void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        for (int sz = 1; sz < a.length; sz = sz + sz)
            for (int lo = 0; lo < a.length - sz; lo = lo + sz + sz)
                merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, a.length - 1));
    }
}