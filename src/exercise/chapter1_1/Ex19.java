package exercise.chapter1_1;

public class Ex19 {
    public static void main(String[] args) {
        for (int N = 0; N < 100; N++) {
//            System.out.println(N + " " + F(N));
            System.out.println(N + " " + fibonacci(N));
        }
    }

    private static long F(int N) {
        if (N == 0) return 0;
        if (N == 1) return 1;
        return F(N - 1) + F(N - 2);
    }

    private static long fibonacci(int N) {
        int f = 0;
        int g = 1;
        for (int i = 0; i < N; i++) {
            f = f + g;
            g = f - g;
        }
        return f;
    }
}
