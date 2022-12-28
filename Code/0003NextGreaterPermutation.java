    /*
    (Helper)
    --------
    Given an array of Integers, reverse it. 
    
    Time Complexity  : O(n)
    Space Complexity : O(1) 
    */
    public static void reverseArray(int[] array, int start, int end) {
        for (int i = start; i < ((start + end) / 2); i++) {
            int temp = array[end - i];
            array[end - i] = array[i];
            array[i] = temp;
        }
    }

    /*
    Problem Statement
    -----------------
    Given an array of size n, change the array to its next permutation.
   
    Time Complexity  : O(n)
    Space Complexity : O(1)
    */
    public static void nextGreaterPermutationArray(int[] array) {
        // 1 4 3 2 0
        // 1 0 2 3 4

        // find the last element of increasing subarray from end 
        // including array's last element
        int index1 = array.length - 1;
        boolean isNonIncreasing = false;
        int lastElement = array[index1];

        for (int i = index1; i > 0; i--) {
            if (array[i - 1] < array[i]) {
                index1 = i;
                break;
            }
            if (i == 0) {
                isNonIncreasing = true;
            }
        }
        if (isNonIncreasing) {
            reverseArray(array, 0, array.length - 1);
            return;
        }

        for (int i = array.length - 1; i > index1; i--) {
            array[i] = array[i - 1];
        }

        array[index1] = lastElement;
        reverseArray(array, index1 + 1, array.length - 1);

    }
