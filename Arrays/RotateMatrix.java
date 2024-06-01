public class RotateMatrix {

    /*
    (Helper)
    --------
    Given a square matrix, transpose it
    
    Time Complexity  : O(m*n) m=rows n=columns
    Space Complexity : O(1)
     */
    public static void transposeSquareMatrix(int[][] matrix) {
        int temp;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[0].length; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    /*
    (Helper)
    --------
    Given a square matrix, flip matrix horizontally
    
    Time Complexity  : O(m*n) m=rows n=columns
    Space Complexity : O(1)
     */
    public static void flipMatrixHorizontally(int[][] matrix) {
        int temp;
        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[matrix.length - i - 1][j];
                matrix[matrix.length - i - 1][j] = temp;
            }
        }
    }

    /*
    Problem Statement
    -----------------
    Given a square matrix, rotate matrix anticlockwise by 90 degree
    
    Time Complexity  : O(m*n) m=row size n=column size
    Space Complexity : O(1)
     */
    public static void rotateMatrixAntiClockwise90Degree(int[][] matrix) {
        transposeSquareMatrix(matrix);
        flipMatrixHorizontally(matrix);
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println("Original Matrix:");
        printMatrix(matrix);

        rotateMatrixAntiClockwise90Degree(matrix);

        System.out.println("Matrix after 90-degree anticlockwise rotation:");
        printMatrix(matrix);
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
