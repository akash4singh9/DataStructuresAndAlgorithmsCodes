public class Stocks1 {

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
    Given an array of stock prices for n days. Make one transaction with maximum
    profit. Incase, profit can't be made, return 0.
   
    Time Complexity  : O(n)
    Space Complexity : O(1)
     */
    public static int maxProfitOneTransaction(int[] array) {
        int index = firstIncreasingElement(array);
        if (index == -1) {
            return 0;
        }

        int boughtAt = array[index];
        int maxProfit = 0;

        for (int i = index + 1; i < array.length; i++) {
            if (array[i] < boughtAt) {
                boughtAt = array[i];
            } else {
                maxProfit = Math.max(maxProfit, array[i] - boughtAt);
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] stockPrices = {7, 1, 5, 3, 6, 4};

        int maxProfit = maxProfitOneTransaction(stockPrices);

        System.out.println("Maximum Profit from one transaction: " + maxProfit);
    }
}
