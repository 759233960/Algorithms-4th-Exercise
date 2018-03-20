package api;

import java.util.Scanner;

/**
 * input API
 */
public class StdIn {
    private static Scanner scanner = new Scanner(System.in);

    public static int readInt() {
        return scanner.nextInt();
    }

    public static String readLine() {
        return scanner.nextLine();
    }

    public static boolean hasNextLine() {
        return scanner.hasNextLine();
    }

    public static boolean hasNext() {
        return scanner.hasNext();
    }
}
