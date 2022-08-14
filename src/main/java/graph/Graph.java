package graph;

import java.util.*;
import java.util.List;

public class Graph {
    Map<String, List<String>> graph = new HashMap<String, List<String>>();
    public void addEdge(String node,String neighbour){
        if(!graph.containsKey(node)){

            List<String> list = new LinkedList<String>();
            if (!neighbour.equals("")) {
                list.add(neighbour);
            }
            graph.put(node,list);
        }else {
            List<String> list = graph.get(node);
            list.add(neighbour);
        }
    }

    public Map<String, List<String>> getGraph(){
        return graph;
    }
}
