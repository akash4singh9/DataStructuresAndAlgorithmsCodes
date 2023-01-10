    /*
    Problem Statement
    -----------------
    Given a non decreasing array of size n and an integer target, return
    another integer representing any index at which that target element may be
    present and -1 if it is not present in the array
    
    Time Complexity  : O(n.log(n)) log has base 2
    Space Complexity : O(n.log(n))
    */

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
