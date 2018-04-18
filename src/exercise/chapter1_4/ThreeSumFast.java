package exercise.chapter1_4;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class ThreeSumFast {
    //统计和为0的元组的数量 O(N^2lnN)
    public static int count(int[] a) {
        Arrays.sort(a);
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++) {//O(N)
            for (int j = i + 1; j < N; j++) {//O(N)
                if (BinarySearch.rank(-a[i] - a[j], a) > j) {
                    cnt++;// O(lnN)
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] a = In.readInts(args[0]);
        StdOut.println(count(a));
    }
}
