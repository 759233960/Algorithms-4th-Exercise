package exercise.chapter1_1;

public class Ex06 {
    public static void main(String[] args) {
        fibonacci(15);
    }

    private static void fibonacci(int N) {
        long f = 0;
        long g = 1;
        for (int i = 0; i < N; i++) {
            System.out.print("[ " + f + " ]    ");
            f = f + g;
            g = f - g;
        }
    }
}
