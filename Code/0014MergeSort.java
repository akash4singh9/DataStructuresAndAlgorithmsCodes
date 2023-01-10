
class Program {

  public static int[] auxArray;
  
    /*
    (Helper)
    -----------------
    Given an array of length n, and four integers start1,end1,start2,end2 
    end2=end1+1 and 0<=start1<=end1<=end2<=start2<n.
    array is sorted between the indices start1 and end1 (both inclusive)
    and between start2 and end2 (both inclusive).
    Sort the array between start1 and end2 (both inclusive).
    
    Time Complexity  : O(k) , k=end2-start1+1
    Space Complexity : O(n) 
    */
   
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
    
    /*
    (Helper)
    -----------------
    Given an array of size n, a start index and an end index sort the array.
    Sort the array between the start and end indices including both indices.
    Sorted form of the array is the non decreasing permutation of 
    the array. Use merge sort algorithm.
    
    Time Complexity  : O(k.log(k)), k=end-start+1 , log has base 2
    Space Complexity : O(n)
    */
  public static void mergeSort(int[] array, int start, int end)
  {
    if(start>=end)
      return;
    int mid=(start+end)/2;
    mergeSort(array,start,mid);
    mergeSort(array,mid+1,end);
    merge(array,start,mid,mid+1,end);
  }
  
    /*
    Problem Statement
    -----------------
    Given an array of size n, sort the array.
    Sorted form of the array is the non decreasing permutation of 
    the array. Use merge sort algorithm.
    
    Time Complexity  : O(n.log(n)), log has base 2
    Space Complexity : O(n)
    */
  public static int[] mergeSort(int[] array) 
  {
      auxArray=new int[array.length];
      mergeSort(array,0,array.length-1);
      return array;
  }

  
}
