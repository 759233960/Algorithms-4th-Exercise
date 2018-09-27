package LeetCodeExcercise;

/**
 * 852. 山脉数组的峰顶索引
 * 我们把符合下列属性的数组 A 称作山脉：
 * <p>
 * A.length >= 3
 * 存在 0 < i < A.length - 1 使得A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
 * 给定一个确定为山脉的数组，返回任何满足 A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1] 的 i 的值。
 */
public class ex852 {
    public int peakIndexInMountainArray(int[] A) {
        int lo = 1, hi = A.length - 2;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            if (A[mid] <= A[mid - 1]) hi = mid - 1;
            else if (A[mid] <= A[mid + 1]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    public int peakIndexInMountainArray2(int[] A) {
        for (int i = 1; i < A.length; i++)
            if (A[i - 1] > A[i])
                return i - 1;
        return -1;
    }
}
