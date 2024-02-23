package Sorting;

import java.util.Random;
import java.util.Arrays;

public class SortingTests {
    public
    static Integer totalTests = 1000;
    public static Integer passedTests = 0;

    public static void runTests() {
        /*
         * Test for Empty Array
         * Test for Array with one element
         * Test for Array with N elements each same
         * Other Random Tests
         * */

        int[] array1 = new int[]{};
        int[] array2 = new int[]{1};
        int[] array3 = new int[]{1, 1, 1, 1, 1, 1};

        individualTests(array1);
        individualTests(array2);
        individualTests(array3);

        int[] array4;

        for (int i = 0; i < totalTests; i++) {
            Random random = new Random();
            int length = random.nextInt(i + 2) + 2;
            array4 = new int[length];
            for (int j = 0; j < length; j++) {
                array4[j] = random.nextInt(i + 2);
            }
            boolean comparison = individualTests(array4);
            if (!comparison) {
                break;
            }
            passedTests++;
            //System.out.println(" Test No. " + passedTests + " passed");
        }
        System.out.println("Tests Passed : " + passedTests + " out of " + totalTests);
    }

    public static boolean individualTests(int[] array) {
        System.out.println("12121 "+Arrays.toString(array));

        int[] arr=array.clone();
        InsertionSort sort = new InsertionSort();
        int[] clonedArray = array.clone();
        sort.insertionSort(array);
        Arrays.sort(clonedArray);
        boolean result = compareArray(array, clonedArray);//Arrays.sort(array4.clone()));
        if(!result)
        {
            System.out.println("The test for sorting failed on the test case : ");
            System.out.println(Arrays.toString(arr));
            System.out.println(Arrays.toString(array));
        }
        return result;
    }

    public static boolean compareArray(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            return false;
        }
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("This is a file which tests the correctness of sorting algorithms");
        runTests();
    }
}