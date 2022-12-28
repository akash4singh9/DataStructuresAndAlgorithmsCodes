    /*
    (Helper)
    --------
    Given a line of Pascal's Triangle as list, return the next line as list
    
    Time Complexity  : O(n)
    Space Complexity : O(n) 
    */
    public static ArrayList<Integer> generateNextLinePascalTriangle(ArrayList<Integer> previousLine) {
        ArrayList<Integer> newLine = new ArrayList<>();
        newLine.add(1);
        for (int i = 0; i < previousLine.size() - 1; i++) {
            newLine.add(previousLine.get(i) + previousLine.get(i + 1));
        }
        newLine.add(1);
        return newLine;
    }

    /*
    Problem Statement
    -----------------
    Given an integer n, return the Pascal's triangle upto n height in the form 
    of list of list

    Time Complexity  : O(n^2)
    Space Complexity : O(n^2)
    
    imports: 
    import java.util.ArrayList;
     */
    public static ArrayList<ArrayList<Integer>> pascalsTriangle(int n) {
        ArrayList<ArrayList<Integer>> pascalsTriangle = new ArrayList<>();
        ArrayList<Integer> firstLine = new ArrayList<>();
        firstLine.add(1);
        pascalsTriangle.add(firstLine);
        for (int i = 1; i < n; i++) {
            pascalsTriangle.add(pascalsTriangle.get(pascalsTriangle.size() - 1));
        }
        return pascalsTriangle;
    }
