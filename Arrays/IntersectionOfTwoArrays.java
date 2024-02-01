public class IntersectionOfTwoArrays {
    public int[] intersect(final int[] array1, final int[] array2)
    {
        HashMap<Integer,Integer> mapOfarray1=new HashMap<>();
        HashMap<Integer,Integer> mapOfarray2=new HashMap<>();
        HashMap<Integer,Integer> intersection=new HashMap<>();

        for(int i:array1)
            if(!mapOfarray1.containsKey(i))
                mapOfarray1.put(i,1);
            else
                mapOfarray1.put(i,mapOfarray1.get(i)+1);

        for(int i:array2)
            if(!mapOfarray2.containsKey(i))
                mapOfarray2.put(i,1);
            else
                mapOfarray2.put(i,mapOfarray2.get(i)+1);


        int count=0;
        for(int i: mapOfarray1.keySet())
        {
            if(mapOfarray2.containsKey(i))
            {
                intersection.put(i,Math.min(mapOfarray1.get(i),mapOfarray2.get(i)));
                count+=intersection.get(i);
            }
        }

        int size=intersection.size();
        int pos=0;
        int[] array=new int[count];

        for(int i: intersection.keySet())
            for(int j=0;j<intersection.get(i);j++)
                array[pos++]=i;

        Arrays.sort(array);
        return array;

    }
}
