import java.util.*;

class Program {

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
