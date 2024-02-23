package Sorting;
import java.util.Arrays;
import java.util.Random;
public class QuickSort {

    public void quickSort(int[] array)
    {
        if (array.length <= 1)
            return;
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] array, int start, int end) {
        if(!(start>=0 && end <array.length && end>start))
            return;
        int pivot = partition(array,start,end);
        quickSort(array,start,pivot-1);
        quickSort(array,pivot+1,end);
    }

    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public  int partition(int[] array,int start, int end)
    {
        int pivot = (new Random()).nextInt(end-start)+start+1;
        int pivotNumber = array[pivot];
        swap(array,pivot,end);
        int i=start;int j=end-1;
        while(i<=j)
        {
            if(array[i]>pivotNumber)
            {
                swap(array,i,j);
                j--;
            }
            else {
                i++;
            }
        }
        swap(array,end,j+1);
        return j+1;
    }

    public static void main(String[] args)
    {
        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            int length = random.nextInt(i + 2) + 2;
           int[] array4 = new int[length];
            for (int j = 0; j < length; j++) {
                array4[j] = random.nextInt(i + 2)+10;
            }
            System.out.println(Arrays.toString(array4));
         //   System.out.println(partition(array4,0,array4.length-1));
            System.out.println(Arrays.toString(array4));
            System.out.println();
        }
    }

}
