package exercise.chapter1_1;

public class Ex13 {
    public static void main(String[] args) {
        translateMatrix(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    }

    private static void translateMatrix(int[][] matrix) {
        int M = matrix.length;
        int N = matrix[0].length;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(matrix[j][i] + "\t");
            }
            System.out.println();
        }


    }
}
