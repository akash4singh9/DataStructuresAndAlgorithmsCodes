import java.util.*;

class Program {
  public static int findMin(int[] array,int start,int end)
  {
    int minAt=start;
    for(int i=start;i<=end;i++)
      if(array[minAt]>array[i])
        minAt=i;
    return minAt;
  }

  public static void swap(int[] array,int i1,int i2)
  {
    int temp=array[i1];
    array[i1] =array[i2];
    array[i2] =temp;
  }
  
  public static int[] selectionSort(int[] array) {
    for(int i=0;i<array.length;i++)
          swap(array,i,findMin(array,i,array.length-1));
    return array;
  }
}
