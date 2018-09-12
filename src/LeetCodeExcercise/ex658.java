package LeetCodeExcercise;

import java.util.ArrayList;
import java.util.List;

/**
 * 658. 找到 K 个最接近的元素
 * 给定一个排序好的数组，两个整数 k 和 x，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。如果有两个数与 x 的差值一样，优先选择数值较小的那个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,4,5], k=4, x=3
 * 输出: [1,2,3,4]
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: [1,2,3,4,5], k=4, x=-1
 * 输出: [1,2,3,4]
 * <p>
 * <p>
 * 说明:
 * <p>
 * k 的值为正数，且总是小于给定排序数组的长度。
 * 数组不为空，且长度不超过 10^4
 * 数组里的每个元素与 x 的绝对值不超过 10^4
 */

public class ex658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>(k);
        int lo = 0, hi = arr.length - k - 1;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            if (Math.abs(x - arr[mid]) > Math.abs(x - arr[mid + k]))
                lo = mid + 1;
            else hi = mid - 1;
        }
        for (int i = 0; i < k; i++)
            list.add(arr[lo + i]);
        return list;
    }


    //非二分法，采用首尾逼近
    public List<Integer> findClosestElements2(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>(k);
        for (int i : arr) list.add(i);
        while (list.size() > k) {
            if (x - list.get(0) <= list.get(list.size() - 1) - x)
                list.remove(list.size() - 1);
            else list.remove(list.get(0));
        }
        return list;
    }
}
