  /*
    Problem Statement
    -----------------
    Given an array of length n, and an integer mid(mid<n). The subarray array[0...mid-1]
    and array[mid...n-1] are sorted. Sort the complete array.
    
    Time Complexity  : O(n)
    Space Complexity : O(n) 
     */
    public static void merge2SortedArrays(int[] array, int mid) {
        int[] auxiliary=new int[array.length]; 
        int pos = 0;
        int i = 0;
        int j = mid;

        while (i < mid && j < array.length) {`
            if (array[i] > array[j]) {
                array[pos++] = array[j++];
            } else {
                array[pos++] = array[i++];
            }
        }

        while (i < mid) {
            array[pos++] = array[i++];
        }

        while (j < array.length) {
            array[pos++] = array[j++];
        }
    }
