package graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class UndirectedGraphPathCheck {
    static List<String> visitedNode = new LinkedList<String>();
    public static boolean hasPath(Map<String,List<String>> graph,String source,String destiantion){
        Stack<String> stack = new Stack<>();
        stack.add(source);
        while(stack.size() > 0){
            String node = stack.pop();
            if(isVisited(node)){
                continue;
            }
            if(node.equals(destiantion)){
                return true;
            }
            List<String> neighbours = graph.get(node);
            for (String neighbour : neighbours){
                stack.add(neighbour);
            }
            updateNodeVisit(node);
        }
        return false;
    }

    public static boolean isVisited(String node){
        return visitedNode.contains(node);
    }

    public static void updateNodeVisit(String node){
        visitedNode.add(node);
    }


    public static void main(String ats[]){
        Graph graph = new Graph();
        graph.addEdge("i","j");
        graph.addEdge("i","k");
        graph.addEdge("j","i");
        graph.addEdge("k","i");
        graph.addEdge("k","m");
        graph.addEdge("k","l");
        graph.addEdge("m","k");
        graph.addEdge("l","k");
        graph.addEdge("o","n");
        graph.addEdge("n","o");
        Map<String, List<String>> nodes = graph.getGraph();
        System.out.println(nodes);

        System.out.println(hasPath(nodes,"i","l"));

    }
}
