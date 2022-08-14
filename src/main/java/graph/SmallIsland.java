package graph;

import java.util.*;

public class SmallIsland {

    static List<String> visitedNodes = new LinkedList<String>();
    static int length = 0;
    public static int minimumIsland(int[][] input){
        int minLength = Integer.MAX_VALUE;
        for(int i=0;i<input.length;i++){
            for(int j=0;j<input[0].length;j++){

                if(input[i][j] == 1){
                    int length = findIslandLength(input,i,j);
                    System.out.println(length);
                    if(length < minLength){
                        minLength = length;
                    }
                }
                length = 0;
            }
        }
        if(minLength == Integer.MAX_VALUE){
            minLength = 0;
        }

        return minLength;
    }
    public static int findIslandLength(int[][] input,int row,int col){
        if(row <0 || col <0 || row >= input.length || col >= input[0].length){
            return 0;
        }

        if(input[row][col] == 0){
            return 0;
        }
        String indice = row +","+col;
        if(visitedNodes.contains(indice)){
            return 0;
        }
        input[row][col]=0;
        length = length +1;
        visitedNodes.add(indice);

        findIslandLength(input,row+1,col);
        findIslandLength(input,row-1,col);
        findIslandLength(input,row,col+1);
        findIslandLength(input,row,col-1);
        return length;

    }

    public static void main(String aths[]){

        int input[][] = new int[][] { { 1, 1, 0, 0, 0 },
                { 1, 1, 0, 0, 1 },
                { 1, 0, 0, 1, 1 }};

        System.out.println("Number of islands is: " + SmallIsland.minimumIsland(input));

    }

}
