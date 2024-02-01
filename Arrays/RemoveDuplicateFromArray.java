public class RemoveDuplicatesFromArray {
    public int removeDuplicates(ArrayList<Integer> array)
    {
        ArrayList<Integer> list=new ArrayList<>();
        list.add(array.get(0));
        for(int i=1;i<array.size();i++)
        {
            Integer a=array.get(i);
            Integer b=array.get(i-1);
            if(!a.equals(b))
            {
                list.add(array.get(i));
            }
        }
        array.clear();
        for(Integer i: list)
            array.add(i);
        return array.size();
    }
}
