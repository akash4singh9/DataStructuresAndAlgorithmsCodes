public class MergeTwoSortedArrays {

    public static long get(long arr1[], long arr2[], int index) {
        if (index < arr1.length) {
            return arr1[index];
        } else {
            return arr2[index - arr1.length];
        }
    }

    public static void set(long arr1[], long arr2[], int index, long value) {
        if (index < arr1.length) {
            arr1[index] = value;
        } else {
            arr2[index - arr1.length] = value;
        }
    }

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

    public static void main(String[] args) {
        long[] arr1 = {1, 5, 9, 10};
        long[] arr2 = {2, 3, 8, 13};
        int n = arr1.length;
        int m = arr2.length;

        System.out.println("Array 1 before merge:");
        printArray(arr1);
        System.out.println("Array 2 before merge:");
        printArray(arr2);

        merge(arr1, arr2, n, m);

        System.out.println("Array 1 after merge:");
        printArray(arr1);
        System.out.println("Array 2 after merge:");
        printArray(arr2);
    }

    public static void printArray(long[] array) {
        for (long num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
