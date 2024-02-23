package Sorting;

public class BubbleSort
{
    /*
    (Helper)
    -----------------
    Given an array and two integers, swap the elements in the array
    at those two indices.

    Time Complexity  : O(1)
    Space Complexity : O(1)
    */
    public void swap(int[] array, int a, int b)
    {
        int temp=array[b];
        array[b]=array[a];
        array[a]=temp;
    }

    /*
    Problem Statement
    -----------------
    Given an array of size n, sort the array.
    Sorted form of the array is the non-decreasing permutation of
    the array. Use bubble sort algorithm.

    Time Complexity  : O(n^2)
    Space Complexity : O(1)
    */
    public int[] bubbleSort(int[] array) {

        for(int i=0;i<array.length;i++)
        {
            for(int j=0;j<array.length-1-i;j++)
            {
                if(array[j+1]<array[j])
                {
                    swap(array,i,j+1);
                }
            }
        }
        return array;
    }
}