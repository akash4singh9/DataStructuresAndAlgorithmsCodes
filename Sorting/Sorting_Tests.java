import java.util.Random;

class ResultData
{

}
public class SortingTests
{

    public boolean result = false;
    public Integer totalTests=0;
    public Integer passedTests=10000;

    public void runTests()
    {
        /*
        * Test for Empty Array
        * Test for Array with one element
        * Test for Array with N elements each same
        * Other Random Tests
        * */

        int[] array1=new int[]{};
        int[] array2=new int[]{1};
        int[] array3=new int[]{1,1,1,1,1,1};
        int[] array4;

        for(int i=0;i<10000;i++)
        {
            Random random = new Random();
            int length=random.nextInt(i+2)+2;
            array4=new int[length];
            for(int j=0;j<length;j++)
            {
                array4[j]=random.nextInt(i+2);
            }
            BubbleSort sort=new BubbleSort();
            int[] sortedArray= sort.bubbleSort(array4);
            boolean comparison = compareArray(sortedArray,Arrays.sort(array4.clone()));
            if(!comparison)
            {
                break;
            }
            passedTests++;
            System.out.println(" Test No. "+passedTests+" passed");
        }
        System.out.println("Tests Passed : "+ passedTests +" out of "+totalTests);

    }

    public boolean compareArray(int[] array1, int array2)
    {
        if(array1.length!=array2.length)
        {
            return false;
        }
        for(int i=0;i<array1.length;i++)
        {
            if(array1[i]!=array2[i])
            {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args)
    {
        System.out.println("This is a file which tests the correctness of sorting algorithms");

    }
}