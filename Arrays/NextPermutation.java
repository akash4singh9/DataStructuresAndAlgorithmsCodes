
    /*
    (Helper)
    --------
    Given an array of Integers, reverse it. 
    
    Time Complexity  : O(n)
    Space Complexity : O(1) 
    */
    public static void reverseArray(int[] array, int start, int end) {
        for (int i = start; i <= ((start + end) / 2); i++) {
            int temp = array[start + end - i];
            array[start + end - i] = array[i];
            array[i] = temp;
        }
    }

    /*
    (Helper)
    --------
    Given an array of Integers return a boolean representing whether it is
    non increasing. 
    
    Time Complexity  : O(n)
    Space Complexity : O(1) 
    */
    public static boolean isNonIncreasing(int[] array) {
        boolean isNonIncreasing = true;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i + 1] > array[i]) {
                isNonIncreasing = false;
            }
        }
        return isNonIncreasing;
    }

    /*
    (Helper)
    --------
    Given an array of Integers return a boolean representing whether it is
    non decreasing. 
    
    Time Complexity  : O(n)
    Space Complexity : O(1) 
    */
    public static boolean isNonDecreasing(int[] array) {
        boolean isNonDecreasing = true;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i + 1] < array[i]) {
                isNonDecreasing = false;
            }
        }
        return isNonDecreasing;
    }

    /*
    (Helper)
    --------
    Given an array of integers, return the integer value index where the 
    subarray array[index ..... array.length-1] is decreasing subarray and 
    array and array[index-1]<array[index].
    
    This functions assumes that the input array is not either purely 
    non-increasing or purely non-decreasing.
    
    Time Complexity  : O(n)
    Space Complexity : O(1)
     */
    public static int endOfIncreasingSubarrayFromEnd(int[] array) {
        int index1 = array.length - 1;
        for (int i = index1; i > 0; i--) {
            if (array[i - 1] < array[i]) {
                index1 = i;
                break;
            }
        }
        return index1;

    }

    /*
    (Helper)
    --------
    Given an array of integers, a key , a start value and an end value.
    0<=start<array.length
    0<=end<array.length
    
    array is non increasing between the indices start and end. Find an index i, 
    such that array[i]>key and key>array[i+1]. Place key at array[i] and return 
    array[i].
    
    This functions assumes that the input array is not either purely 
    non-increasing or purely non-decreasing.
    
    Time Complexity  : O(n)
    Space Complexity : O(1)
    
    */
    public static int insertAtCorrectPosition(int[] array, int key, int start, int end) {
        int temp = 1;

        if (start == end) {
            temp = array[end];
            array[end] = key;
            return temp;
        }

        for (int i = start; i <= end; i++) {

            if (i == end) {
                temp = array[end];
                array[end] = key;
                return temp;
            }
            if (array[i] >= key && array[i + 1] < key) {
                temp = array[i];
                array[i] = key;
                return temp;
            }
        }
        return temp;
    }

    /*
    Problem Statement
    -----------------
    Given an array of size n, change the array to its next permutation.
    Next permutation of a descending array is its sorted version.
   
    Time Complexity  : O(n)
    Space Complexity : O(1)
     */
    public static void nextGreaterPermutationArray(int[] array) {
        // check if the array is non decreasing
        // swap last two elements

        boolean isNonDecreasing = isNonDecreasing(array);
        boolean isNonIncreasing = isNonIncreasing(array);

        if (array.length == 1) {
            return;
        }

        if (isNonDecreasing) {
            int temp = array[array.length - 1];
            array[array.length - 1] = array[array.length - 2];
            array[array.length - 2] = temp;
            return;
        }

        if (isNonIncreasing) {
            reverseArray(array, 0, array.length - 1);
            return;
        }

        int index = endOfIncreasingSubarrayFromEnd(array);
        int replace = insertAtCorrectPosition(array, array[index - 1], index, array.length - 1);
        array[index - 1] = replace;
        reverseArray(array, index, array.length - 1);
    }
