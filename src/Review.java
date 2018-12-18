abstract class BaseSort {
    public abstract void sort(Comparable[] a);

    public boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public void exchange(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}

class Selection extends BaseSort {

    @Override
    public void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (less(a[j], a[min])) min = j;
            }
            exchange(a, min, i);
        }
    }
}

class Insertion extends BaseSort {

    @Override
    public void sort(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exchange(a, j, j - 1);
            }
        }
    }
}

class Shell extends BaseSort {

    @Override
    public void sort(Comparable[] a) {
        int h = 1;
        while (h < a.length / 3) h = h * 3 + 1;
        while (h > 1) {
            for (int i = h; i < a.length; i++) {
                for (int j = i; j > h && less(a[j], a[j - h]); j -= h) {
                    exchange(a, j, j - h);
                }
            }
            h = h / 3;
        }
    }
}

abstract class Merge extends BaseSort {
    Comparable[] aux;

    void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        for (int k = i; k <= hi; k++)
            aux[k] = a[k];
        for (int k = i; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(a[j], a[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }
}

class MergeUB extends Merge {

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

class MergeBU extends Merge {

    @Override
    public void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        for (int sz = 1; sz < a.length; sz += sz) {
            for (int lo = 0; lo < a.length - sz; lo = lo + sz + sz) {
                merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, a.length - 1));
            }
        }
    }
}

class QuickSort extends BaseSort {

    @Override
    public void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        while (true) {
            while (less(a[++i], a[lo])) if (i == hi) break;
            while (less(a[lo], a[--j])) if (j == lo) break;
            if (i >= j) break;
            exchange(a, i, j);
        }
        exchange(a, lo, j);
        return j;
    }
}

class QuickSory3Way extends BaseSort {

    @Override
    public void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) return;
        int lt = lo, gt = hi, i = lo + 1;
        Comparable v = a[lo];
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) exchange(a, lt++, i++);
            else if (cmp > 0) exchange(a, i, gt--);
            else i++;
        }
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }
}