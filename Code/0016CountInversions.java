
class Program {
  
  
  public static int[] auxArray;
  public static int inversions;
  
  
    /*
    (Helper)
    -----------------
    Given an array of length n, and four integers start1,end1,start2,end2 
    end2=end1+1 and 0<=start1<=end1<=end2<=start2<n.
    array is sorted between the indices start1 and end1 (both inclusive)
    and between start2 and end2 (both inclusive).
    Sort the array between start1 and end2 (both inclusive).
    While doing so also count the inversions occured.
    
    Time Complexity  : O(k) , k=end2-start1+1
    Space Complexity : O(n) 
    */
  public static void merge(int[] array,int start1, int end1,int start2,int end2 )
  {
    int pos=start1;
    int i=start1;
    int j=start2;
    
    while(i<=end1&&j<=end2)
        if(array[i]<=array[j])
          auxArray[pos++]=array[i++];
        else
        {
          inversions+=(j-i)-(j-start2);
          auxArray[pos++]=array[j++];
        }
     
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
    While doing so your function should call the merge method which counts 
    the inversions.
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
  Given an array of length n, return number of inversions required to sort the array.
  Inversion occurs if for any two valid indices a and b such that 0<=a<b<n 
  array[a]>array[b].
  
  Note: The algorithm uses the merge sort algorithm to count the inversions.
  It calls the mergeSort method which then calls merge method.
  */
  public int countInversions(int[] array) {
    inversions=0;
    mergeSort(array,0,array.length-1);
    return inversions;
  }
}
