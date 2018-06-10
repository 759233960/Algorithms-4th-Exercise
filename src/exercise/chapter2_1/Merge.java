package exercise.chapter2_1;

/**
 * Created by Yif on 6/10/2018.
 */
public class Merge extends Example {

    private Comparable[] aux;

    private void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        //sort left-hand
        sort(a, lo, mid);
        //sort right-hand
        sort(a, mid + 1, hi);
        //merge result
        merge(a, lo, mid, hi);
    }

    @Override
    public void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }
}
