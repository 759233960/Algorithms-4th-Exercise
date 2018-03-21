package exercise.chapter1_3;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.StdIn;

/**
 * 1.3.1 Bag example code
 * 背包是一种不支持从中删除元素的集合数据类型
 * 他的目的就是迭代遍历集合中所有元素，且顺序随机和元素无关。用于处理大型平均数、加权平均等无关顺序的数值。
 */
public class Stats {
    public static void main(String[] args) {
        Bag<Double> numbers = new Bag<>();
        while (!StdIn.isEmpty()) {
            numbers.add(StdIn.readDouble());
        }
        int n = numbers.size();

        double sum = 0.0;
        for (double x : numbers) {
            sum += x;
        }
        double mean = sum / n;

        sum = 0.0;
        for (double x : numbers) {
            sum += (x - mean) * (x - mean);
        }
        double std = Math.sqrt(sum / (n - 1));

        System.out.printf("Mean: %.2f\n", mean);//平均值
        System.out.printf("Std dev: %.2f\n", std);//加权平均数
    }
}
