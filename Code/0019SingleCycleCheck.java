
  /*
  (Helper)
  Given an array of size n, any index i in the array represents the jump we
  can make from that position in that array and the sign represents
  the direction. 
  
  Consider the array :
  Index:   0   1   2   3   4   5
  Values:  2   3   1  -4  -4   2

  From index 0 we can jump to (index + array[index])  2.
  Positive number represents right jump.
  Negative number represents left jump.
  Jumps can be wrapped around.
  
  Consider that this results in a Graph.
  Return the adjacency list for this graph.
  As every element will be connected to atmost one other element
  return a arraylist of integers , ith index representing the 
  element i will be redirecting to.
  
  Time Complexity : O(n)
  Space Complexity: O(n)
  
  imports: 
  java.util.ArrayList;
  */
  public static ArrayList<Integer> getAdjacencyList(int[] array)
  {
    ArrayList<Integer> list=new ArrayList<Integer>();
    int size=array.length;
    for(int i=0;i<size;i++)
      {
          int element=i;
          if(array[i]!=0)
          element=(i+size+(((Math.abs(array[i]))%size)*(array[i]/Math.abs(array[i]))))%size;
          list.add(element);      
      }
    return list;
  }
  
  

  /*
  (Problem Statement)
  Given an array of size n, any index i in the array represents the jump we
  can make from that position in that array and the sign represents
  the direction. 
  
  Consider the array :
  Index:   0   1   2   3   4   5
  Values:  2   3   1  -4  -4   2

  From index 0 we can jump to (index + array[index])  2.
  Positive number represents right jump.
  Negative number represents left jump.
  Jumps can be wrapped around.
  
  Check whether we can make a single cycle.
  To explain, Check whether there exists any element for which if we start from that index
  we come back to it after traversing every other indices exactly once. 
  
  Time Complexity : O(n)
  Space Complexity: O(n)
  
  imports: 
  java.util.ArrayList;
  java.util.Stack;
  */
  public static boolean hasSingleCycle(int[] array) {
    ArrayList<Integer> list=getAdjacencyList(array);
    boolean[] isVisited=new boolean[array.length];
    Stack<Integer> dfsStack=new Stack<>();
    dfsStack.push(0);
    int count=0;
    while(!dfsStack.isEmpty())
      {
          int currElement=dfsStack.pop();
          if(isVisited[currElement])
            if(count!=array.length)
              return false;
            else
              if(currElement==0)
              return true;
        isVisited[currElement]=true;
        count+=1;  
        dfsStack.push(list.get(currElement));  
      }
    return false;
  }
