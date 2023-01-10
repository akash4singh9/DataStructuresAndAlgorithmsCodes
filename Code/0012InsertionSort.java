import java.util.*;

class Program {

    /*
    (Helper)
    -----------------
    Given an array of size n, and an index i.
    Array is non decreasing upto index i-1.
    Make the array sorted(non decreasing) upto index i.
    
    Time Complexity  : O(n)
    Space Complexity : O(1)
    */
  public static void insert(int[] array,int index)
  {
    int swapIndex=index;
    for(int i=0;i<index;i++)
      if(array[i]>=array[index])
      {
        swapIndex=i;
        break;
      }
      
    int elementAtIndex=array[index];
    for(int i=index;i>swapIndex;i--)
        array[i]=array[i-1];
    
    array[swapIndex]=elementAtIndex;
 }
  
    /*
    Problem Statement
    -----------------
    Given an array of size n, sort the array.
    Sorted form of the array is the non decreasing permutation of 
    the array. Use insertion sort algorithm.
    
    Time Complexity  : O(n^2)
    Space Complexity : O(1)
    */
  public static int[] insertionSort(int[] array) {
    for(int i=1;i<array.length;i++)
      insert(array,i);
    return array;
  }
}
