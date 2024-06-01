public class ThreeNumberSort {

  /*
  Problem Statement
  -----------------
  Given an array input of size n and an array order of size 3.
  The input consists of numbers only from order.
  Rearrange the input in such a way that the elements must be in the order
  as they are in order array.
 
  Time Complexity  : O(n)
  Space Complexity : O(1)
  */
  public int[] threeNumberSort(int[] array, int[] order) {
      int countOfOrder0 = 0;
      int countOfOrder1 = 0;
      int countOfOrder2 = 0;

      // Count occurrences of each element in the order array
      for (int i : array) {
          if (order[0] == i) {
              countOfOrder0++;
          } else if (order[1] == i) {
              countOfOrder1++;
          } else if (order[2] == i) {
              countOfOrder2++;
          }
      }

      // Fill the array with elements in the specified order
      int index = 0;
      for (int i = 0; i < countOfOrder0; i++) {
          array[index++] = order[0];
      }
      for (int i = 0; i < countOfOrder1; i++) {
          array[index++] = order[1];
      }
      for (int i = 0; i < countOfOrder2; i++) {
          array[index++] = order[2];
      }

      return array;
  }

  /*
  Another (Special case of above)
  Problem Statement
  -----------------
  Given an array of size n, which only has 0s, 1s, and 2s, sort it.
  This is a case of the problem statement above when the order array
  is [0,1,2].
  
  Time Complexity  : O(n)
  Space Complexity : O(1)
  */
  public static void sort012(byte[] array) {
      int zeroes = 0;
      int ones = 0;

      // Count occurrences of 0s and 1s
      for (byte b : array) {
          if (b == 0) {
              zeroes++;
          } else if (b == 1) {
              ones++;
          }
      }

      // Fill the array with 0s, 1s, and 2s
      int index = 0;
      while (zeroes-- > 0) {
          array[index++] = 0;
      }
      while (ones-- > 0) {
          array[index++] = 1;
      }
      while (index < array.length) {
          array[index++] = 2;
      }
  }

  public static void main(String[] args) {
      // Test threeNumberSort
      int[] array = {3, 3, 2, 1, 3, 2, 1};
      int[] order = {1, 2, 3};

      ArraySorter sorter = new ArraySorter();
      int[] sortedArray = sorter.threeNumberSort(array, order);

      System.out.println("Array after threeNumberSort:");
      for (int num : sortedArray) {
          System.out.print(num + " ");
      }
      System.out.println();

      // Test sort012
      byte[] array012 = {0, 1, 2, 0, 1, 2, 0, 2, 1};

      sort012(array012);

      System.out.println("Array after sort012:");
      for (byte b : array012) {
          System.out.print(b + " ");
      }
  }
}
