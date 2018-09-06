package LeetCodeExcercise;

/**
 * 704. 二分查找
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 * 示例 2:
 * <p>
 * 输入: nums = [-1,0,3,5,9,12], target = 2
 * 输出: -1
 * 解释: 2 不存在 nums 中因此返回 -1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 你可以假设 nums 中的所有元素是不重复的。
 * n 将在 [1, 10000]之间。
 * nums 的每个元素都将在 [-9999, 9999]之间。
 */
public class ex704 {
    public int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        if (lo == hi) {
            if (target == nums[lo]) return lo;
            else return -1;
        }
        int mid;
        while (nums[lo] < nums[hi]) {
            mid = (lo + hi) >>> 2;
            if (lo == mid || hi == mid) {
                if (target == nums[lo]) return lo;
                else if (target == nums[hi]) return hi;
                else return -1;
            }
            if (target < nums[mid]) hi = mid;
            else if (target > nums[mid]) lo = mid;
            else return mid;
        }
        return -1;
    }
}
