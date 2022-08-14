package graph;

import java.util.*;

public class GraphPathCheck {

    public static boolean hasPath(Map<String,List<String>> graph,String source, String destination){
        Queue<String> stack = new LinkedList<String>();
        stack.add(source);
        while(stack.size()>0){
            String target = stack.poll();
            if(target.equals(destination)){
                return true;
            }
            List<String> neighbours = graph.get(target);
            System.out.println(target);
            for(String neighbour : neighbours){
                stack.add(neighbour);
            }
        }

        return false;
    }

    public static void main(String ats[]){
        Graph graph = new Graph();
        graph.addEdge("f","g");
        graph.addEdge("f","i");
        graph.addEdge("i","g");
        graph.addEdge("j","i");
        graph.addEdge("i","k");
        graph.addEdge("g","h");
        graph.addEdge("k","");
        graph.addEdge("h","");
        Map<String, List<String>> nodes = graph.getGraph();
        System.out.println(nodes);

        System.out.println(hasPath(nodes,"f","j"));

    }
}
