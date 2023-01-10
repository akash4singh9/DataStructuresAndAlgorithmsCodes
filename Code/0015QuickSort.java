

class Program {

    /*
    (Helper)
    -----------------
    Given an array of size n, an integer start and an integer end.
    Rearrange the elements of the array between the start and end indices (both inclusive) 
    such that all the elements less than array[start] appear on the left of the array[start] and
    all the elements greater than array[start] appear on the right of the array[end].Doing so 
    makes array[start] come to a place where it would have been if the array was sorted between
    start and end indices including both.
    
    Time Complexity  : O(k), k=end-start+1
    Space Complexity : O(1)
    */

  public static int partition(int[] array, int start, int end)
  {
    if(start>=end)
      return -1;
    if(start<0 || start>=array.length)
      return -1;
    if(end<0 || end>=array.length)
      return -1;
   
    int pivot=start;
    int i=start+1;
    int j=end;
    
    while(i<=j && i<=end && j>start)
      {
        if(array[i]>array[pivot] && array[j]<array[pivot] )
        {
          int temp=array[i];
          array[i]=array[j];
          array[j]=temp;
          i++;
          j--;
        }
        else if (array[i]<=array[pivot])
          i++;
        else
          j--;
      }
    int temp=array[i-1];
    array[i-1]=array[pivot];
    array[pivot]=temp;
    return i-1;
  }
  
    /*
    Problem Statement
    -----------------
    Given an array of size n, sort the array.
    Sorted form of the array is the non decreasing permutation of 
    the array. Use quick sort algorithm.
    
    Time Complexity  : O(n^2)
    Space Complexity : O(1)
    */
  public static void quickSort(int[] array, int start, int end)
  {
    if(start>=end)
      return ;
    int pivotPosition=partition(array,start,end);
    if(pivotPosition==-1)
      return ;
    quickSort(array,start,pivotPosition-1);
    quickSort(array,pivotPosition+1,end);
  }
  
  public static int[] quickSort(int[] array) {
    quickSort(array,0, array.length-1);
    return array;
  }
}
