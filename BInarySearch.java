import java.util.*;
//Recursive Binary Search
//Time Complexity O(log n)
//Space Complexity O(log n)

class Program {

  public static int binarySearch(int[] array,int start,int end,int target)
  {
    if(start>end)
      return -1;
    int mid=(start+end)/2;
    if(array[mid]==target)
      return mid;
    else if(array[mid]<target)
      return binarySearch(array,mid+1,end,target);
    else//(array[mid]>target)
      return binarySearch(array,start,mid-1,target);
  } 
  
  public static int binarySearch(int[] array, int target) {
    // Write your code here.
    return binarySearch(array,0,array.length-1,target);
  }
}
