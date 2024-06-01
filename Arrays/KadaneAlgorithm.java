import java.util.*;

class Program {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(kadanesAlgorithm(array));
    }

    public static int maxInArray(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int i : array)

            if (i > max)
                max = i;
        return max;
    }

    public static int kadanesAlgorithm(int[] array) {
        for (int i = 1; i < array.length; i++)
            array[i] = Math.max(array[i - 1] + array[i], array[i]);
        return maxInArray(array);
    }
}
