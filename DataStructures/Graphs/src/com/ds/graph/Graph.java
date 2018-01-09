import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
// This class represents an undirected graph using adjacency list
// representation
class Graph{
    //num of vertices
    public int V;
    public Map<Integer, ArrayList<Integer>> adjacent = new HashMap<>();

    public Graph(int size){
        this.V = size;
    }

    // Create entries for all nodes
    public void addEdge(int from,int to){

        if(!adjacent.containsKey(from)){
            adjacent.put(from,new ArrayList<Integer>());
        }

        if(!adjacent.containsKey(to)){
            adjacent.put(to,new ArrayList<Integer>());
        }

        if(!adjacent.get(from).contains(to)){
            adjacent.get(from).add(to);
        }

    }



}
