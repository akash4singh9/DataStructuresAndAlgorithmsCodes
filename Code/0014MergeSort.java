import java.util.*;

class Program {

  public static int[] auxArray;
  
  public static void merge(int[] array,int start1, int end1,int start2,int end2 )
  {
    int pos=start1;
    int i=start1;
    int j=start2;
    
    while(i<=end1&&j<=end2)
        if(array[i]<array[j])
          auxArray[pos++]=array[i++];
        else
          auxArray[pos++]=array[j++];
     
    while(i<=end1)
      auxArray[pos++]=array[i++];
     
    while(j<=end2)
      auxArray[pos++]=array[j++];

    for(int k=start1;k<=end2;k++)
      array[k]=auxArray[k];
  }

  public static void mergeSort(int[] array, int start, int end)
  {
    if(start>=end)
      return;
    int mid=(start+end)/2;
    mergeSort(array,start,mid);
    mergeSort(array,mid+1,end);
    merge(array,start,mid,mid+1,end);
  }
  
  public static int[] mergeSort(int[] array) 
  {
      auxArray=new int[array.length];
      mergeSort(array,0,array.length-1);
      return array;
  }

  
}
