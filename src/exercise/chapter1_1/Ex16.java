package exercise.chapter1_1;

public class Ex16 {
    public static void main(String[] args) {
        System.out.println(exR1(6));
    }

    private static String exR1(int n) {
        if (n <= 0)
            return "";
        return exR1(n - 3) + n + exR1(n - 2) + n;
    }
}