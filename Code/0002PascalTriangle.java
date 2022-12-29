    /*
    (Helper)
    --------
    Given a line of Pascal's Triangle as list, return the next line as list
    
    Time Complexity  : O(n)
    Space Complexity : O(n) 
    */
    public static ArrayList<Long> generateNextLinePascalTriangle(ArrayList<Long> previousLine) {
        ArrayList<Long> newLine = new ArrayList<>();
        newLine.add(1L);
        for (int i = 0; i < previousLine.size() - 1; i++) {
            newLine.add(previousLine.get(i) + previousLine.get(i + 1));
        }
        newLine.add(1L);
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
    public static ArrayList<ArrayList<Long>> pascalsTriangle(int n) {
        ArrayList<ArrayList<Long>> pascalsTriangle = new ArrayList<>();
        ArrayList<Long> firstLine = new ArrayList<>();
        firstLine.add(1L);
        pascalsTriangle.add(firstLine);
        for (int i = 1; i < n; i++) {
            firstLine=generateNextLinePascalTriangle(firstLine);
            pascalsTriangle.add(firstLine);
        }
        return pascalsTriangle;
    }
