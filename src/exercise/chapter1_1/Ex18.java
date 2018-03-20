package exercise.chapter1_1;

public class Ex18 {
    public static void main(String[] args) {
        System.out.println(mystery(2, 25));
        System.out.println(mystery(3, 11));
        System.out.println(mystery2(2, 24));
        System.out.println(mystery2(3, 10));

        System.out.println("*----------------------------*");

        System.out.println(mystery2(2, 25));
        System.out.println(mystery2(3, 11));
        System.out.println(mystery2(2, 24));
        System.out.println(mystery2(3, 10));
    }

    private static int mystery(int a, int b) {
        if (b == 0) return 0;
        if (b % 2 == 0) return mystery(a + a, b / 2);
        return mystery(a + a, b / 2) + a;
    }

    private static int mystery2(int a, int b) {
        if (b == 0) return 1;
        if (b % 2 == 0) return mystery(a * a, b / 2);
        return mystery(a * a, b / 2) * a;
    }
}
