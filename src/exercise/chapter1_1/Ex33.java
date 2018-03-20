package exercise.chapter1_1;

public final class Ex33 {
    public static void main(String[] args) {
        double[] result = dot(new double[]{1.0, 2.0, 3.0, 4.0, 5.0, 6.0}, new double[]{3.0, 4.0, 5.0});
        printMatrix(result);
        printMatrix(multiply(new double[][]{{1, 2, 3}, {4, 5, 6}}, new double[][]{{1, 4}, {2, 5}, {3, 6}}));
    }

    public static double[] dot(double[] x, double[] y) {
        double[] result = new double[x.length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < y.length; j++) {
                result[i] = result[i] + x[i] * y[j];
            }
        }
        return result;
    }

    public static double[][] multiply(double[][] a, double[][] b) {
        if (a[0].length != b.length) {
            throw new IllegalArgumentException("matrix error");
        }
        double[][] result = new double[a.length][b[0].length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                for (int k = 0; k < a[0].length; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return result;
    }


    public static void printMatrix(double[] result) {
        System.out.println();
        for (double a : result) {
            System.out.print("|" + "\t");
            System.out.printf("%.2f", a);
            System.out.print("\t");
        }
        System.out.print("|");
        System.out.println();
    }

    public static void printMatrix(int[] result) {
        System.out.println();
        for (double a : result) {
            System.out.print("|" + "\t");
            System.out.print(a);
            System.out.print("\t");
        }
        System.out.print("|");

    }

    public static void printMatrix(double[][] result) {
        System.out.println();
        for (double[] a : result) {
            for (double b : a) {
                System.out.print("|" + "\t");
                System.out.printf("%.2f", b);
                System.out.print("\t");
            }
            System.out.print("|");
            System.out.println();
        }
    }
}
