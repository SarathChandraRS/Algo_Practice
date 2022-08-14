package graph;

import java.util.*;
import java.util.stream.Collectors;

public class MaxSumForTotalGraphNodes {
    public int solution(int N, int[] A, int[] B) {
        Graph graph = new Graph();
        int result = 0;
        for(int i =0; i< A.length;i++){
            graph.addEdge(A[i],B[i]);
            graph.addEdge(B[i],A[i]);
        }
        Map<Integer, List<Integer>> nodes = graph.getGraph();
        Map<Integer, List<Integer>> sortedNodes = nodes.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.comparingInt(List::size))).collect(Collectors.toMap(Map.Entry::getKey,
                Map.Entry::getValue, (a, b) -> {
                    throw new AssertionError();
                }, LinkedHashMap::new));
        int count = N-sortedNodes.size()+1;
        for(Map.Entry<Integer, List<Integer>> entry:sortedNodes.entrySet()){
            int i = entry.getValue().size() * count;
            result = result + i;
            count++;
        }
        return result;
    }

    class Graph{
        Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
        public void addEdge(Integer node,Integer neighbour){
            if(!graph.containsKey(node)){

                List<Integer> list = new LinkedList<Integer>();
                list.add(neighbour);
                graph.put(node,list);
            }else {
                List<Integer> list = graph.get(node);
                list.add(neighbour);
            }
        }

        public Map<Integer, List<Integer>> getGraph(){
            return graph;
        }
    }

    public static void main(String args[]){
        int A[] = {2, 2, 1, 2};
        int D[] = {1, 3, 4, 4};
        MaxSumForTotalGraphNodes solution = new MaxSumForTotalGraphNodes();
        System.out.println(solution.solution(5,A,D));
    }
}
