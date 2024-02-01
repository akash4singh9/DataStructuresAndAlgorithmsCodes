import java.util.*;

public class Graph {

    private int[][] adjMatrix;
    private ArrayList<LinkedList<Integer>> adjList;
    public boolean zeroBased;

    public Graph(int[][] adjMatrix, ArrayList<LinkedList<Integer>> adjList) {
        this.adjMatrix=adjMatrix;
        this.adjList=adjList;
    }

    public Graph(int v)
    {
        this.adjList=new ArrayList<LinkedList<Integer>>();
        for(int i=0;i<v;i++)
            adjList.add(new LinkedList<Integer>());
        this.adjMatrix=new int[v][v];
    }

    public boolean addEdge(int v1,int v2)
    {
        if(!zeroBased)
            v1--;v2--;

        if(!(0<=v1 && v1<adjMatrix.length && 0<=v1&& v1<adjMatrix.length))
        {
            adjMatrix[v1][v2]=1;
            adjMatrix[v2][v1]=1
            adjList.set(v1,adjList.get(v1).add(v2));
        }
    }

    public boolean removeEdge(int v1,int v2)
    {

    }
}