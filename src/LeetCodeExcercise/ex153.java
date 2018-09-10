package LeetCodeExcercise;

/**
 * 153. 寻找旋转排序数组中的最小值
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 请找出其中最小的元素。
 * <p>
 * 你可以假设数组中不存在重复元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,4,5,1,2]
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: [4,5,6,7,0,1,2]
 * 输出: 0
 */
public class ex153 {
    public int findMin(int[] nums) {
        for (int i = 1; i < nums.length; i++)
            if (nums[i] < nums[i - 1]) return nums[i];
        return nums[0];
    }

    public int findMin2(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        if (nums[lo] <= nums[hi]) return nums[lo];
        while (lo != hi - 1) {
            int mid = (lo + hi) >>> 1;
            if (nums[mid] > nums[lo]) lo = mid;
            else hi = mid;
        }
        return nums[lo] < nums[hi] ? nums[lo] : nums[hi];
    }
}
