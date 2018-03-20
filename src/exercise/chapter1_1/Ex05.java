package exercise.chapter1_1;

import java.util.Scanner;

public class Ex05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x = scanner.nextDouble();
        double y = scanner.nextDouble();

        System.out.println(x > 0 && y > 0 && Math.abs(x - y) < 1);
        System.out.println(x > 0 && y > 0 && x < 1 && y < 1);
    }
}
