import java.util.*; 

class Program {
  
    /*
    (Helper)
    -----------------
    Given an array of size n, an index start and an index end.
    Return the index of the minimum number between the indices start and end
    (both inclusive).
    
    Time Complexity  : O(n)
    Space Complexity : O(1)
    */
  
  public static int findMin(int[] array,int start,int end)
  {
    int minAt=start;
    for(int i=start;i<=end;i++)
      if(array[minAt]>array[i])
        minAt=i;
    return minAt;
  }
  
    /*
    Problem Statement
    -----------------
    Given an array of size n, and two integers i1 and i2 such that
    0<=i1<n and 0<=i2<n. Swap the numbers at the indices i1 and i2.
    
    Time Complexity  : O(1)
    Space Complexity : O(1)
    */
  
  public static void swap(int[] array,int i1,int i2)
  {
    int temp=array[i1];
    array[i1] =array[i2];
    array[i2] =temp;
  }
  
  
    /*
    Problem Statement
    -----------------
    Given an array of size n, sort the array.
    Sorted form of the array is the non decreasing permutation of 
    the array. Use selection sort algorithm.
    
    Time Complexity  : O(n^2)
    Space Complexity : O(1)
    */
  public static int[] selectionSort(int[] array) {
    for(int i=0;i<array.length;i++)
          swap(array,i,findMin(array,i,array.length-1));
    return array;
  }
}
