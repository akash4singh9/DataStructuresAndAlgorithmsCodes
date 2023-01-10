import java.util.*;

class Program {

  //array 
  //array is sorted till index-1

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
  
  public static int[] insertionSort(int[] array) {
    for(int i=1;i<array.length;i++)
      insert(array,i);
    return array;
  }
}
