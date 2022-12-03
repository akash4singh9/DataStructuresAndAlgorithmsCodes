import java.util.*;
//Linear Search
//Time Complexity O(n)
//Space Complexity O(1)

class Program {

  public static int linearSearch(int[] array, int target) {
    // Write your code here.
    for(int i=0;i<array.length;i++)
      if(array[i]==target)
        return i;
    return -1;
  }
}
