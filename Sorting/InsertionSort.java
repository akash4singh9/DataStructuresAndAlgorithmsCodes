package Sorting;

public class InsertionSort {

    /*
    Problem Statement
    -----------------
    Given an array, start and end indices and an integer shiftBy.
    Shift all the elements of the array between the position between
    start and end (both inclusive) by "shiftBy".
    Assume that end + shiftBy <array.length

    Time Complexity  : O(n)
    Space Complexity : O(1)
    */
    public void shiftRight(int[] array, int start, int end, int shiftBy) {
        if (!(start >= 0 && end < array.length && end >= start)) return;
        for (int i = end; i >= start; i--) {
            array[i + shiftBy] = array[i];
        }
    }

    /*
    Problem Statement
    -----------------
    Given an array of size n, start,end and index as integers,
    Insert array[index] between array[start] and array[end],
    and shift the elements to right of new position of
    array[index] such that array remains sorted from start to end+1.
    Time Complexity  : O(n)
    Space Complexity : O(1)
    */
    public void insert(int[] array, int start, int end, int index) {
        for (int i = start; i <= end; i++) {
            if (array[index] <= array[i]) {
                int temp = array[index];
                shiftRight(array, i, end, 1);
                array[i] = temp;
                return;
            }
        }
    }

    /*
    Problem Statement
    -----------------
    Given an array of size n, sort the array.
    Sorted form of the array is the non-decreasing permutation of
    the array. Use insertion sort algorithm.

    Time Complexity  : O(n^2)
    Space Complexity : O(1)
    */
    public void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            insert(array, 0, i - 1, i);
        }
    }
}
