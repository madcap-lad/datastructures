import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.Map;
import java.util.Arrays;
import java.lang.reflect.Array;
import java.util.*;


class TopologicalSort
{
    private static Graph g = new Graph(6);
    public static void main(String[] args) {


        g.addEdge(12,7);
        g.addEdge(10,5);
        g.addEdge(9,5);
        g.addEdge(5,6);
        g.addEdge(7,8);
        g.addEdge(8,6);


        System.out.println(g.adjacent);
        topologicalSort();
    }

    public static void topologicalSort(){

        HashSet<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        for(Map.Entry<Integer,ArrayList<Integer>> entry: g.adjacent.entrySet()){
            Integer key = entry.getKey();
            if(!visited.contains(key)){
                topologicalSortUtils(key,visited,stack);
            }
        }

    }

    public static void topologicalSortUtils(Integer key, HashSet<Integer> visited, Stack<Integer> stack){

        visited.add(key);
        ArrayList<Integer> adjacentList = g.adjacent.get(key);

        for(Integer currentAdjacent: adjacentList){
            if(!visited.contains(currentAdjacent)){
                topologicalSortUtils(currentAdjacent,visited,stack);
            }
        }

        stack.push(key);
    }

}
