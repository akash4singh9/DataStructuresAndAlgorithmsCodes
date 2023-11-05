import java.util.*;

class Program {

    /*
    (Helper)
    --------
    Given an array of Integers return the maximum value.

    Time Complexity  : O(n)
    Space Complexity : O(1)
    */
    public static int maxInArray(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int i : array)
            if (i > max)
                max = i;
        return max;
    }

    /*
    Problem Statement
    -----------------
    Given an array of size n containing negative integers, possibly.
    Find the largest subarray sum

    Time Complexity  : O(n)
    Space Complexity : O(1)
    */
    public static int kadanesAlgorithm(int[] array) {
        for (int i = 1; i < array.length; i++)
            array[i] = Math.max(array[i - 1] + array[i], array[i]);
        return maxInArray(array);

    }
}
