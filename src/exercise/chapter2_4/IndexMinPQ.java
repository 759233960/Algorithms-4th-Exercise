package exercise.chapter2_4;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 基于索引的优先队列，默认最小堆
 * <herf>https://www.cnblogs.com/nullzx/p/6624731.html</herf>
 */
public class IndexMinPQ<Key extends Comparable<Key>> implements Iterable<Integer> {
    private Key[] keys;     //有优先级之分的元素
    private int[] pq;       //索引二叉堆，从1开始
    private int[] qp;       //pq的逆序：qp[pq[i]] = pq[qp[i]] = i
    private int n;          //元素的数量
    private int maxN;
    private Comparator<? super Key> comparator;

    public IndexMinPQ(int maxN) {
        this.maxN = maxN;
        n = 0;
        keys = (Key[]) new Object[maxN + 1];
        pq = new int[maxN + 1];
        qp = new int[maxN + 1];
        for (int i = 0; i < qp.length; i++) qp[i] = -1;
    }

    public IndexMinPQ(int maxN, Comparator<? super Key> comparator) {
        this(maxN);
        this.comparator = comparator;
    }

    public void insert(int k, Key key) {
        ++n;
        pq[n] = k;
        qp[k] = n;
        keys[k] = key;
        swim(n);
    }

    public void change(int k, Key key) {
        if (!contains(k)) return;
        keys[k] = key;
        swim(qp[k]);
        sink(qp[k]);
    }

    public boolean contains(int k) {
        return qp[k] != -1;
    }

    public void delete(int k) {
        if (!contains(k)) return;
        int index = qp[k];
        exchange(index, n--);
        swim(index);
        sink(index);
        qp[k] = -1;
        keys[k] = null;
    }

    public Key min() {
        return keys[pq[1]];
    }

    public int minIndex() {
        return pq[1];
    }

    public int delMin() {
        int min = pq[1];
        exchange(1, n--);
        sink(1);

        assert min == pq[n + 1];

        qp[min] = -1;
        keys[min] = null;
        pq[n + 1] = -1;
        return min;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    private void swim(int k) {
        while (k > 1 && less(k, k / 2)) {
            exchange(k, k / 2);
            k /= 2;
        }
    }

    private void sink(int k) {
        while (k << 1 <= n) {
            int j = k << 1;
            if (j < n && less(j + 1, j)) j++;
            if (!less(j, k)) break;
            exchange(k, j);
            k = j;
        }
    }

    private boolean less(int i, int j) {
        if (comparator == null)
            return keys[pq[i]].compareTo(keys[pq[j]]) < 0;
        else return comparator.compare(keys[pq[i]], keys[pq[j]]) < 0;
    }

    private void exchange(int i, int j) {
        int temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }

    @NotNull
    @Override
    public Iterator<Integer> iterator() {
        return new HeapIterator();
    }

    private class HeapIterator implements Iterator<Integer> {

        private IndexMinPQ<Key> copy;

        public HeapIterator() {
            copy = new IndexMinPQ<>(pq.length - 1);
            for (int i = 1; i < n; i++) {
                copy.insert(pq[i], keys[pq[i]]);
            }
        }

        @Override
        public boolean hasNext() {
            return !copy.isEmpty();
        }

        @Override
        public Integer next() {
            if (!hasNext()) throw new NoSuchElementException();
            else return copy.delMin();
        }
    }
}
