import java.util.ArrayList;

public class PascalTriangle {

    public static ArrayList<Integer> generateNextLinePascalTriangle(ArrayList<Integer> previousLine) {
        ArrayList<Integer> newLine = new ArrayList<>();
        newLine.add(1);
        for (int i = 0; i < previousLine.size() - 1; i++) {
            newLine.add(previousLine.get(i) + previousLine.get(i + 1));
        }
        newLine.add(1);
        return newLine;
    }

    public static ArrayList<ArrayList<Integer>> pascalsTriangle(int n) {
        ArrayList<ArrayList<Integer>> pascalsTriangle = new ArrayList<>();
        ArrayList<Integer> firstLine = new ArrayList<>();
        firstLine.add(1);
        pascalsTriangle.add(firstLine);
        for (int i = 1; i < n; i++) {
            firstLine = generateNextLinePascalTriangle(firstLine);
            pascalsTriangle.add(firstLine);
        }
        return pascalsTriangle;
    }

    public ArrayList<ArrayList<Integer>> solve(int A) {
        if (A == 0) return new ArrayList<ArrayList<Integer>>();
        return pascalsTriangle(A);
    }

    public static void main(String[] args) {
        PascalTriangle pt = new PascalTriangle();
        int n = 10;
        ArrayList<ArrayList<Integer>> result = pt.solve(n);
        System.out.println("Pascal's Triangle up to height " + n + ":");
        printPascalsTriangle(result);
    }

    private static void printPascalsTriangle(ArrayList<ArrayList<Integer>> triangle) {
        int height = triangle.size();
        int maxWidth = height * 2;

        for (int i = 0; i < height; i++) {
            ArrayList<Integer> line = triangle.get(i);
            int padding = (maxWidth - line.size() * 2) / 2;

            // Print leading spaces for alignment
            for (int j = 0; j < padding; j++) {
                System.out.print(" ");
            }

            // Print the numbers in the line
            for (int num : line) {
                System.out.print(num + " ");
            }

            // Move to the next line
            System.out.println();
        }
    }
}
