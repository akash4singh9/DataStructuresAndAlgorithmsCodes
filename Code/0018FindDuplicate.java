 /*
    Problem Statement
    -----------------
    Given an array of size n+1 and given that 1<=array[i]<=n
    for any i such that 0<=i<n. There is only one such number 
    which is repeating , everything else comes once.
    Return this number.
    
    Time Complexity  : O(n)
    Space Complexity : O(1)
     */
    public static int repeatingNumber(int[] array) {
        long sum = 0L;
        long part1 = array.length;
        long part2 = array.length + 1;

        if (array.length % 2 == 0) {
            part1 = array.length / 2;
        }
        if ((array.length + 1) % 2 == 0) {
            part2 = (array.length + 1) / 2;
        }

        sum = part1 * part2;
        long sumOfArray = 0L;
        for (int i : array) {
            sumOfArray += i;
        }

        return (int) (sumOfArray - sum);
    }
