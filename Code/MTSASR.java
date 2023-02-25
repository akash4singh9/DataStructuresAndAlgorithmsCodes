  /*
    Problem Statement
    -----------------
    Given an array of length n, and an integer mid(mid<n). The subarray array[0...mid-1]
    and array[mid...n-1] are sorted. Sort the complete array.
    
    Time Complexity  : O(n)
    Space Complexity : O(n) 
     */
    public static int[] merge2SortedArrays(int[] array, int mid) {
        int[] auxiliary=new int[array.length]; 
        int pos = 0;
        int i = 0;
        int j = mid;

        while (i < mid && j < array.length) {`
            if (array[i] > array[j]) {
                auxiliary[pos++] = array[j++];
            } else {
                auxiliary[pos++] = array[i++];
            }
        }

        while (i < mid) {
            auxiliary[pos++] = array[i++];
        }

        while (j < array.length) {
            auxiliary[pos++] = array[j++];
        }
      return auxiliary;
    }
