    /*
    Helper
    -----------------
    Given two long arrays and an index return the element at the index if these 
    two arrays would have been one combined array : [arr1:arr2]
    
    Time Complexity  : O(1)
    Space Complexity : O(1)
    */
    public static long get(long arr1[], long arr2[], int index) {
        if (index < arr1.length) {
            return arr1[index];
        } else {
            return arr2[index - arr1.length];
        }
    }

    
    /*
    Helper
    -----------------
    Given two long arrays and an index set the element at the index to value if these 
    two arrays would have been one combined array : [arr1:arr2]
    
    Time Complexity  : O(1)
    Space Complexity : O(1)
    */
    public static void set(long arr1[], long arr2[], int index, long value) {
        if (index < arr1.length) {
            arr1[index] = value;
        } else {
            arr2[index - arr1.length] = value;
        }
    }

     /*
    Problem Statement 
    -----------------
    Given two long arrays (of sizes m and n respectively) which are individually
    sorted. Modify these arrays such that if both are concatenated one after
    other the result is a sorted array.
    
    
    Time Complexity  : O((m+n)log(m+n))
    Space Complexity : O(1)
    */
    public static void merge(long arr1[], long arr2[], int n, int m) {
        int gap = (int) Math.ceil((double) (n + m) / 2.0);
        while (gap > 0) {

            int pos1 = 0;
            int pos2 = gap;
            while (pos2 < (m + n)) {
                if (get(arr1, arr2, pos1) > get(arr1, arr2, pos2)) {
                    long temp = get(arr1, arr2, pos1);
                    set(arr1, arr2, pos1, get(arr1, arr2, pos2));
                    set(arr1, arr2, pos2, temp);
               }
                pos1++;
                pos2++;
            }
            if (gap == 1) {
                gap = 0;
            } else {
                gap = (int) Math.ceil((double) gap / 2.0);
            }
        }

    }
