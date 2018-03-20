package exercise.chapter1_1;

import java.util.Scanner;

public class Ex14 {
    public static void main(String[] args) {
        int N = new Scanner(System.in).nextInt();
        System.out.println(lg(N));
//        System.out.println((int) (Math.log(N) / Math.log(2)));
    }

    private static int lg(int N) {
        int max = 0;
        String s = Integer.toBinaryString(N);
        max = s.length() - 1;
        return max;
    }
}
