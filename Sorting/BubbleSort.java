public class sample
{
    /*
    (Helper)
    -----------------
    Given an array and two integers, swap the elements in the array
    at those two indices.

    Time Complexity  : O(1)
    Space Complexity : O(1)
    */

    public static int[] swap(int[] array, int a, int b)
    {
        int temp=array[b];
        array[b]=array[a];
        array[a]=temp;
        return array;
    }

    /*
    Problem Statement
    -----------------
    Given an array of size n, sort the array.
    Sorted form of the array is the non decreasing permutation of
    the array. Use bubble sort algorithm.

    Time Complexity  : O(n^2)
    Space Complexity : O(1)
    */
    public static int[] bubbleSort(int[] array) {

        for(int i=0;i<array.length;i++)
        {
            for(int j=0;j<array.length-1-i;j++)
            {
                if(array[j+1]<array[j])
                {
                    int temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
        }
        return array;
    }

    public static void main(String[] args)
    {
        System.out.println("This is a somaple program");
    }
}