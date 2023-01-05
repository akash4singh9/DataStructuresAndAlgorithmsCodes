    /*
    (Helper)
    --------
    Given a square matrix, transpose it
    
    Time Complexity  : O(m*n) m=rows n=columns
    Space Complexity : O(1)
     */
    public static void transposeSquareMatrix(int[][] matrix) {
        int temp = -1;
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
        int temp = -1;
        for (int i = 0; i <= (matrix.length / 2); i++) {
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
    Given a square matrix, rotate matrix clockwise by 90 degree
    
    Time Complexity  : O(m*n) m=row size n=column size
    Space Complexity : O(1)
     */
    public static void rotateMatrixClockwise90Degree(int[][] matrix) {
        transposeSquareMatrix(matrix);
        flipMatrixHorizontally(matrix);
    }
