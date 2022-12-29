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

        //check if first column has any zero
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) {
                zeroInFirstColumn = true;
                break;
            }
        }

        //check if first row has any zero
        for (int j = 0; j < cols; j++) {
            if (matrix[0][j] == 0) {
                zeroInFirstRow = true;
                break;
            }
        }

        //use first column and first row as the marker
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        //for any element(except those in top left boundary), if its row top
        //element or column left element is zero set it also to be zero
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        //if first column had zero, set the entire column to be zero
        if (zeroInFirstColumn) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }

        //if first row had zero, set the entire row to be zero
        if (zeroInFirstRow) {
            for (int i = 0; i < cols; i++) {
                matrix[0][i] = 0;
            }
        }

    }
