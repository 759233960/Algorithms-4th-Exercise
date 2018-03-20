package exercise.chapter1_1;

public class Ex07 {
    public static void main(String[] args) {
        double t = 9.0;
        while (Math.abs(t - 9.0 / t) > 0.001) {
            System.out.println(t);
            t = (9.0 / t + t) / 2.0;
        }
        System.out.printf("answer : " + "%.5f\n", t);

        System.out.println("--------------------------------");

        int sum = 0;
        for (int i = 1; i < 1000; i++) {
            for (int j = 0; j < i; j++) {
                sum++;
            }
        }
        System.out.println("answer : " + sum);

        System.out.println("--------------------------------");


        int sum2 = 0;
        for (int i = 1; i < 1000; i *= 2) {
            for (int j = 0; j < 1000; j++) {
                sum2++;
            }
        }
        System.out.println("answer : " + sum2);
    }


}
