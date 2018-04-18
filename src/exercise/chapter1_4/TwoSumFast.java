package exercise.chapter1_4;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class TwoSumFast {
    public static int count(int[] a) {
        //统计和为0的整数对的数量 O(NlnN)
        Arrays.sort(a);
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++) {//O(N)
            if (BinarySearch.rank(-a[i], a) > i) {
                cnt++;//O(a+lnN)
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] a = StdIn.readInts();
        StdOut.println(count(a));
    }
}
