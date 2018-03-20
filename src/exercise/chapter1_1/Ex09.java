package exercise.chapter1_1;

import java.util.Scanner;

public class Ex09 {
    public static void main(String[] args) {
        System.out.println(toBinary(new Scanner(System.in).nextInt()));
        Integer.toBinaryString(100);
    }

    private static String toBinary(int N) {
        String s = "";
        for (int n = N; n > 0; n /= 2) {
            s = (n % 2) + s;
        }
        return s;
    }
}
