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
    // Write your code here.
    int countOfOrder0=0;
    int countOfOrder1=0;
    int countOfOrder2=0;
    
    for(int i:array)
      if(order[0]==i)
        countOfOrder0++;
      else if(order[1]==i)
        countOfOrder1++;
      else if(order[2]==i)
        countOfOrder2++;

    for(int i=0;i<countOfOrder0;i++)
      array[i]=order[0];
    for(int i=countOfOrder0;i<countOfOrder1+countOfOrder0;i++)
      array[i]=order[1];
    for(int i=countOfOrder1+countOfOrder0;i<countOfOrder1+countOfOrder0+countOfOrder2;i++)
      array[i]=order[2];
  
    return array;
    }
    
    /*
    Another (Special case of above)
    Problem Statement
    -----------------
    Given an array of size n,which only has 0s, 1s and 2s, sort it.
    This is a case of the problem statement above when the order array
    is [0,1,2].
    Time Complexity  : O(n)
    Space Complexity : O(1)
    */
    public static void sort012(byte[] array) {

        int zeroes = 0;
        int ones = 0;

        for (int i = 0; i < array.length; i++) {
            switch (array[i]) {
                case 0:
                    zeroes++;
                case 1:
                    ones++;
            }
        }

        byte curr = 0;
        int i = 0;
        while (i < array.length) {
            array[i] = curr;
            if (i == zeroes - 1) {
                curr = 1;
            }
            if (i == zeroes + ones - 1) {
                curr = 2;
            }
        }

    }
