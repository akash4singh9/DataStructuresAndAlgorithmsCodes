import java.util.HashSet;

public class DuplicateInArray {

    /*
    Problem Statement
    -----------------
    Given an array of size n containing integers from 1 to n-1, find the duplicate

    Time Complexity  : O(n)
    Space Complexity : O(1)
    */
    public int repeatedNumber(final int[] array) {
        HashSet<Integer> set=new HashSet<>();
        for(int i:array)
            if(set.contains(i))
                return i;
            else
                set.add(i);
        return -1;
    }
}