package LeetCodeExcercise;

/**
 * 69. x 的平方根
 * 实现 int sqrt(int x) 函数。
 * <p>
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * <p>
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 * 由于返回类型是整数，小数部分将被舍去。
 */
public class ex069 {
    public int mySqrt(int x) {
        if (x <= 1) return x;
        //right = x
        int left = 0, right = x / 2 + 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (x / mid >= mid) left = mid + 1;
            else right = mid;
        }
        return right - 1;
    }

    //牛顿逼近法
    public int mySqrt2(int x) {
        if (x == 0) return 0;
        double last = 0;
        double res = 1;
        while (last != res) {
            last = res;
            res = (res + x / res) / 2;
        }
        return (int) res;
    }
}
