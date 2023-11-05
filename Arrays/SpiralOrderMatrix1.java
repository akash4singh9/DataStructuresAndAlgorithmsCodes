public class SpiralOrderMatrix1 {

    /*
     * Given a square matrix of size n*n, Traverse the matrix in Spiral order and store the results in an array.
     * Return that array.
     *
     * Space Complexity: O(n^2)
     * Time Complexity: O(n^2)
     * */

    public int[] spiralOrder(final int[][] A) {
        int[] result = new int[A.length * (A[0].length)];
        String dir = "right";
        int pos = 0;
        int maxRight = A[0].length - 1;
        int maxLeft = 0;
        int maxDown = A.length - 1;
        int maxUp = 1;
        int i = 0;
        int j = 0;

        if (A.length == 1)
            return A[0];

        if (A[0].length == 1) {
            for (i = 0; i < A.length; i++) {
                result[pos++] = A[i][0];
            }
            return result;
        }

        while (pos < result.length) {
            if (dir.equals("right")) {
                result[pos++] = A[i][j];
                j++;
                if (j == maxRight) {
                    dir = "down";
                    maxRight = j - 1;
                }
            } else if (dir.equals("down")) {
                result[pos++] = A[i][j];
                i++;
                if (i == maxDown) {
                    dir = "left";
                    maxDown = i - 1;
                }
            } else if (dir.equals("left")) {
                result[pos++] = A[i][j];
                j--;
                if (j == maxLeft) {
                    dir = "up";
                    maxLeft = j + 1;
                }
            } else if (dir.equals("up")) {
                result[pos++] = A[i][j];
                i--;
                if (i == maxUp) {
                    dir = "right";
                    maxUp = i + 1;
                }
            }
        }
        return result;
    }
}
