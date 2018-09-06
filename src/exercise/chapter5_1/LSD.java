package exercise.chapter5_1;

/**
 * 低位优先的字符串排序
 * 性能：线性
 * <p>
 * 若是访问N组W个键的元素排序，则需要7WN+3WR次访问数组，与N+R成正比的额外空间。
 * 总体运行时间与输入规模成正比。
 */
public class LSD {
    public static void sort(String[] a, int W) {
        //通过前W个字符将a排序
        int N = a.length;
        int R = 256;
        String[] aux = new String[N];

        for (int d = W - 1; d >= 0; d--) {
            //根据d个字符用键索引计数法排序
            int[] count = new int[R + 1];
            //计算出现的频率
            for (int i = 0; i < N; i++)
                count[a[i].charAt(d) + 1]++;
            //将频率转化为索引
            for (int r = 0; r < R; r++)
                count[r + 1] += count[r];
            //将元素分类
            for (int i = 0; i < N; i++)
                aux[count[a[i].charAt(d)]++] = a[i];
            //回写
            for (int i = 0; i < N; i++)
                a[i] = aux[i];
        }
    }
}
