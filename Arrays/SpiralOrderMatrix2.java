import java.util.Arrays;

public class SpiralOrderMatrix2 {

    /*
     * Given a square matrix of size n*n, Traverse the matrix in Spiral order and store the integers from 1 to n*n.
     * in the matrix.  Return the matrix.
     *
     * Space Complexity: O(n^2)
     * Time Complexity: O(n^2)
     * */
    public int[][] generateMatrix(int n) {
        int counter = 1;
        boolean result = false;
        int[][] array = new int[n][n];
        for (int[] a : array)
            Arrays.fill(a, -1);
        array[0][0] = counter++;
        Point point = new Point(0, 0);
        Direction dir = new Direction("RIGHT");
        int faliureCount = 0;

        while (faliureCount < 2) {
            result = attemptFilling(array, counter, dir, point);
            if (result) {
                counter++;
                faliureCount = 0;
            } else {
                faliureCount++;
            }
        }
        return array;

    }

    public boolean attemptFilling(int[][] matrix, int val, Direction dir, Point p1) {
        Point p2 = changePointAccordingToDirection(dir, p1);
        if (notInLimits(matrix, p2) || matrix[p2.x][p2.y] != -1) {
            dir = changeDirection(dir);
            return false;
        } else {
            matrix[p2.x][p2.y] = val;
            p1.x = p2.x;
            p1.y = p2.y;
            return true;
        }
    }

    public boolean notInLimits(int[][] matrix, Point point) {
        if (point.x < 0 || point.x >= matrix.length)
            return true;
        if (point.y < 0 || point.y >= matrix[0].length)
            return true;
        return false;

    }

    public Point changePointAccordingToDirection(Direction dir, Point point) {
        Point p2 = new Point(point.x, point.y);
        switch (dir.dir) {
            case "RIGHT":
                p2.y++;
                break;
            case "DOWN":
                p2.x++;
                break;
            case "LEFT":
                p2.y--;
                break;
            case "UP":
                p2.x--;
                break;
        }
        return p2;
    }

    public Direction changeDirection(Direction dir) {
        switch (dir.dir) {
            case "RIGHT":
                dir.dir = "DOWN";
                break;
            case "DOWN":
                dir.dir = "LEFT";
                break;
            case "LEFT":
                dir.dir = "UP";
                break;
            case "UP":
                dir.dir = "RIGHT";
                break;
        }
        return dir;
    }

    class Direction {
        String dir;

        public Direction(String dir) {
            this.dir = dir;
        }
    }

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
