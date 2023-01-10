    /*
    Problem Statement
    -----------------
    Given an array of size n and an integer target, return
    another integer representing first index at which that target element may be
    present and -1 if it is not present in the array
    
    Time Complexity  : O(n)
    Space Complexity : O(n)
    */

class Program {

  public static int linearSearch(int[] array, int target) {
    // Write your code here.
    for(int i=0;i<array.length;i++)
      if(array[i]==target)
        return i;
    return -1;
  }
}
