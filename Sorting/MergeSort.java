package Sorting;

import java.util.Arrays;

public class MergeSort {
    /*
    *
    *
    * */
    public void merge(int[] array, int[] aux, int start1, int start2, int end2) {
        int i = start1;
        int j = start2;
        int pos = i;
        while (i < start2 && j <= end2) {
            if (array[i] <= array[j]) {
                aux[pos++] = array[i++];
            } else {
                aux[pos++] = array[j++];
            }
        }
        while (j <= end2) {
            aux[pos++] = array[j++];
        }
        while (i < start2) {
            aux[pos++] = array[i++];
        }
        for (int k = start1; k <= end2; k++) {
            array[k] = aux[k];
        }
    }

    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public int[] mergeSort(int[] array) {
        if (array.length <= 1)
            return array;
        mergeSort(array, 0, array.length - 1);//start, int end);
        return array;
    }

    public void mergeSort(int[] array, int start, int end) {
        if (start >= end)
            return;
        int mid = (end - start) / 2 + start;
        mergeSort(array, start, mid);
        mergeSort(array, mid + 1, end);
        merge(array, new int[array.length], start, mid + 1, end);
    }
}