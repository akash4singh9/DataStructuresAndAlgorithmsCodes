import java.util.*;

class Program {


  public static int[] swap(int[] array, int a, int b)
  {
    int temp=array[b];
    array[b]=array[a];
    array[a]=temp;
    return array;
  }
  public static int[] bubbleSort(int[] array) {
    // Write your code here.


    
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
}
