public class TwoSum {
    public int[] twoSum(final int[] array, int sum)
    {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<array.length;i++)
            if(!(map.containsKey(array[i])))
                map.put(array[i],i);

        for(int i=0;i<array.length;i++)
            if(map.containsKey(sum-array[i])&&i>map.get(sum-array[i]))
                return new int[]{map.get(sum-array[i])+1,i+1};

        return new int[]{};
    }
}
