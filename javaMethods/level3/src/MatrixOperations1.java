import java.util.Random;

public class MatrixOperations1 {

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

    public static int[][] addMatrices(int[][] matrix1, int[][] matrix2) {
        if (matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length) {
            System.out.println("Matrices must have the same dimensions for addition.");
            return null;
        }
        int rows = matrix1.length;
        int cols = matrix1[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return result;
    }

    public static int[][] subtractMatrices(int[][] matrix1, int[][] matrix2) {
        if (matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length) {
            System.out.println("Matrices must have the same dimensions for subtraction.");
            return null;
        }
        int rows = matrix1.length;
        int cols = matrix1[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return result;
    }

    public static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
        if (matrix1[0].length != matrix2.length) {
            System.out.println("Number of columns in the first matrix must equal number of rows in the second.");
            return null;
        }
        int rows1 = matrix1.length;
        int cols1 = matrix1[0].length;
        int cols2 = matrix2[0].length;
        int[][] result = new int[rows1][cols2];

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
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

    public static void main(String[] args) {
        int rows1 = 2;
        int cols1 = 3;
        int rows2 = 3;
        int cols2 = 2;
        int[][] mat1 = createRandomMatrix(rows1, cols1);
        int[][] mat2 = createRandomMatrix(rows2, cols2);

        System.out.println("Matrix 1:");
        displayMatrix(mat1);
        System.out.println("\nMatrix 2:");
        displayMatrix(mat2);

        System.out.println("\nAddition (requires same dimensions):");
        displayMatrix(addMatrices(mat1, mat1));

        System.out.println("\nSubtraction (requires same dimensions):");
        displayMatrix(subtractMatrices(mat1, mat1));

        System.out.println("\nMultiplication:");
        displayMatrix(multiplyMatrices(mat1, mat2));
    }
}