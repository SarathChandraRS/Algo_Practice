package graph;

import java.util.*;

public class ShortestPath{

    static List<String> visitedNodes = new LinkedList<String>();

    public static double shortestPath(Map<String,List<String>> graph, String source,String destination){

        Queue<NodeDistance> queue = new LinkedList<NodeDistance>();
        queue.add(new NodeDistance(source,0.0));

        while(queue.size() > 0){
            NodeDistance nodeData = queue.poll();
            if(nodeData.node.equals(destination)){
                return nodeData.distance;
            }
            if(isVisited(nodeData.node)){
                continue;
            }
            List<String>neighbours = graph.get(nodeData.node);
            for(String neighbour : neighbours){
                queue.add(new NodeDistance(neighbour,nodeData.distance+1));
            }
            updateNodeVisit(nodeData.node);
        }
        return -1.0;
    }

    public static boolean isVisited(String node){
        return visitedNodes.contains(node);
    }

    public static void updateNodeVisit(String node){
        visitedNodes.add(node);
    }
}
class NodeDistance{
    String node;
    double distance;

    public NodeDistance(String node, double distance){
        this.node = node;
        this.distance = distance;
    }
}