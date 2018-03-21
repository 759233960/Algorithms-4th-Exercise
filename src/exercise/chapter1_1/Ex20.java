package exercise.chapter1_1;

import edu.princeton.cs.algs4.StdIn;

public class Ex20 {
    public static void main(String[] args) {
        System.out.println(calculate(StdIn.readInt()));
    }

    /**
     * calculate ln(N!)
     *
     * @param N number
     * @return calculate ln(N!)
     */
    private static double calculate(int N) {
        double answer = 0;
        if (N > 1) {
            return (Math.log(N) + Math.log(N - 1));
//            return (Math.log(N*(N - 1)));
        }
        return answer;
    }
}
