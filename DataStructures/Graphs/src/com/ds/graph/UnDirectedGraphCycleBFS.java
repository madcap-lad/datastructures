//package com.ds.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class UnDirectedGraphCycleBFS {



    public static Boolean isCyclic(int V,LinkedList<Integer>[] alist)
    {
        //parent array indicates if the vertex is visited
        //and if visited it store the parent of the vertex
        int[] parent = new int[V];
        //-1 indicates not visited
        Arrays.fill(parent,-1);
        //incase if graph has different connected components
        for(int i=0;i<V;i++){
            if(parent[i]!=-1)
                continue;
            Queue<Integer> q = new LinkedList<Integer>();
            q.add(i);
            //since i is the root of the bfs tree it doesnt hae any parent
            //and to avoid -1 conflict make itself as its parent
            parent[i]=i;
            while(!q.isEmpty()){
                int src=q.poll();
                for(int adj : alist[src]){
                    //if vertex has edges to itself or
                    //if adjacent vertex has been visited and its not the parent
                    //to the src
                    if(adj==src || (parent[adj]!=-1 && parent[src]!=adj))
                        return true;
                    //if adjacent vertex is parent to the src
                    if(parent[src]==adj)
                        continue;
                    //make the src parent to the adjacent vertex
                    parent[adj]=src;
                    q.add(adj);
                }
            }
        }
        return false;
    }


}
