package exercise.chapter1_1;

public class Ex11 {

    public static void main(String[] args) {
        printBooleanArrays(new boolean[][]{{true, true, false}, {false, false, true}, {false, true, false}, {true, false, true}});
    }

    private static void printBooleanArrays(boolean[][] matrix) {
        for (int i = 1; i <= matrix[0].length; i++) {
            System.out.print("\t" + i);
        }
        System.out.println();
        for (int i = 0; i < matrix.length; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j]) {
                    System.out.print("\t" + "*");
                } else {
                    System.out.print("\t" + " ");
                }
            }
            System.out.println();
        }
    }
}
