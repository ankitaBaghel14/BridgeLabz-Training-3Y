import java.util.Random;

public class MatrixOperations2 {

    public static int[][] createRandomMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextInt(10);
            }
        }
        return matrix;
    }

    public static int[][] transposeMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] transposed = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }
        return transposed;
    }

    public static double determinant2x2(int[][] matrix) {
        if (matrix.length != 2 || matrix[0].length != 2) {
            System.out.println("Not a 2x2 matrix.");
            return Double.NaN;
        }
        return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
    }

    public static double determinant3x3(int[][] matrix) {
        if (matrix.length != 3 || matrix[0].length != 3) {
            System.out.println("Not a 3x3 matrix.");
            return Double.NaN;
        }
        double det = 0;
        det += matrix[0][0] * (matrix[1][1] * matrix[2][2] - matrix[1][2] * matrix[2][1]);
        det -= matrix[0][1] * (matrix[1][0] * matrix[2][2] - matrix[1][2] * matrix[2][0]);
        det += matrix[0][2] * (matrix[1][0] * matrix[2][1] - matrix[1][1] * matrix[2][0]);
        return det;
    }

    public static double[][] inverse2x2(int[][] matrix) {
        double det = determinant2x2(matrix);
        if (det == 0) {
            System.out.println("Inverse does not exist (determinant is zero).");
            return null;
        }
        double[][] inverse = new double[2][2];
        inverse[0][0] = matrix[1][1] / det;
        inverse[0][1] = -matrix[0][1] / det;
        inverse[1][0] = -matrix[1][0] / det;
        inverse[1][1] = matrix[0][0] / det;
        return inverse;
    }

    // Note: 3x3 inverse is complex, typically involves a separate cofactor matrix method
    public static double[][] inverse3x3(int[][] matrix) {
        System.out.println("3x3 matrix inverse implementation is more complex and not shown here.");
        return null;
    }

    public static void displayMatrix(int[][] matrix) {
        if (matrix == null) return;
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.printf("%3d ", element);
            }
            System.out.println();
        }
    }

    public static void displayDoubleMatrix(double[][] matrix) {
        if (matrix == null) return;
        for (double[] row : matrix) {
            for (double element : row) {
                System.out.printf("%8.2f ", element);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] mat2x2 = createRandomMatrix(2, 2);
        int[][] mat3x3 = createRandomMatrix(3, 3);

        System.out.println("Original 2x2 Matrix:");
        displayMatrix(mat2x2);

        System.out.println("\nTranspose:");
        displayMatrix(transposeMatrix(mat2x2));

        System.out.println("\nDeterminant of 2x2: " + determinant2x2(mat2x2));

        System.out.println("\nInverse of 2x2:");
        displayDoubleMatrix(inverse2x2(mat2x2));

        System.out.println("\nOriginal 3x3 Matrix:");
        displayMatrix(mat3x3);

        System.out.println("\nDeterminant of 3x3: " + determinant3x3(mat3x3));
    }
}