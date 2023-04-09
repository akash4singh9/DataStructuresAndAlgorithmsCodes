
    /*
    (Helper)
    --------
    Given an array of Integers, find the first element from where the array
    elements first increase. Return -1 if no such element exists.
    
    Time Complexity  : O(n)
    Space Complexity : O(1) 
     */
    public static int firstIncreasingElement(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i + 1] > array[i]) {
                return i;
            }
        }
        return -1;
    }

    /*
    Problem Statement
    -----------------
    Given an array of stock prices for n days.Make one transaction with maximum
    profit.Incase, profit can't be made, return 0.
   
    Time Complexity  : O(n)
    Space Complexity : O(1)
     */
    public static int maxProfitOneTransaction(int[] array) {
        int index = firstIncreasingElement(array);
        if (index == -1) {
            return 0;
        }

        int boughtAt = index;
        int soldAt = index + 1;
        int maxProfit = array[soldAt] - array[boughtAt];

        for (int i = index + 1; i < array.length; i++) {
            if (array[i] > array[soldAt]) {
                soldAt = i;
                if (array[soldAt] - array[boughtAt] > maxProfit) {
                    maxProfit = array[soldAt] - array[boughtAt];
                }
            }
            if (array[i] < array[boughtAt]) {
                boughtAt = i;
                soldAt = i;
            }
        }

        return maxProfit;
    }
