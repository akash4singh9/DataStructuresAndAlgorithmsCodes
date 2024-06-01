public class SetMatrixZero {

    /*
    Problem Statement
    -----------------
    Given a matrix of 1s and 0s, in the entire matrix, for any element, if it is
    zero, set all the elements of its row and columns as zero.

    Time Complexity  : O(m*n) m=row size n=column size
    Space Complexity : O(1)
    */
    public static void setMatrixZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean zeroInFirstRow = false;
        boolean zeroInFirstColumn = false;

        // Check if the first column has any zero
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) {
                zeroInFirstColumn = true;
                break;
            }
        }

        // Check if the first row has any zero
        for (int j = 0; j < cols; j++) {
            if (matrix[0][j] == 0) {
                zeroInFirstRow = true;
                break;
            }
        }

        // Use the first column and first row as markers
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Set matrix elements to zero based on the markers
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // If the first column had zero, set the entire column to zero
        if (zeroInFirstColumn) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }

        // If the first row had zero, set the entire row to zero
        if (zeroInFirstRow) {
            for (int j = 0; j < cols; j++) {
                matrix[0][j] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 0, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 0}
        };

        System.out.println("Original Matrix:");
        printMatrix(matrix);

        setMatrixZeroes(matrix);

        System.out.println("Matrix after setting zeroes:");
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
