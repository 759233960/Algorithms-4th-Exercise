package exercise.chapter1_1;

import java.util.Scanner;

public class Ex03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.next());
        int b = Integer.parseInt(scanner.next());
        int c = Integer.parseInt(scanner.next());
//        if (a != b) {
//            System.out.println("not equal");
//        } else {
//            if (b != c) {
//                System.out.println("not equal");
//            } else {
//                System.out.println("equal");
//            }
//        }

        if (a == b && a == c) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }


}
