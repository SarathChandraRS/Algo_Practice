package graph;

import java.util.*;
import java.util.Map;

public class GraphTraversal{

    public static void depthFirstTraversal(Map<String,List<String>> graph,String startNode){
        Stack<String> stack = new Stack<String>();
        stack.add(startNode);
        while(stack.size()>0){
            String node = stack.pop();
            System.out.println(node);
            List<String> neighours = graph.get(node);
            for(String neighbour : neighours){
                stack.add(neighbour);
            }
        }
    }

    public static void breadthFirstTraversal(Map<String,List<String>> graph,String startNode){
        Queue<String> queue = new LinkedList<String>();
        queue.add(startNode);
        while(queue.size()>0){
            String node = queue.poll();
            System.out.println(node);
            List<String> neighours = graph.get(node);
            for(String neighbour : neighours){
                queue.add(neighbour);
            }
        }
    }

    public static void main(String args[]){
        Map<String, List<String>> graph = new HashMap<String,List<String>>();
        List<String> list1 = new LinkedList<String>();
        list1.add("c");
        list1.add("b");
        graph.put("a",list1);
        List<String> list2 = new LinkedList<String>();
        list2.add("e");
        graph.put("c",list2);
        List<String> list3 = new LinkedList<String>();
        List<String> list4 = new LinkedList<String>();
        list3.add("d");
        list4.add("f");
        graph.put("b",list3);
        graph.put("d",list4);
        graph.put("f",new LinkedList<String>());
        graph.put("e",new LinkedList<String>());
        depthFirstTraversal(graph,"a");
    }

}
