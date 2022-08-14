package graph;

import java.util.*;

public class IslandCount {


    static List<String> visitedList = new LinkedList<String>();
    public static int islandCount(int[][] input){
        int count=0;
        for(int i=0;i<input.length;i++){
            for(int j=0;j<input[0].length;j++){

                if(input[i][j] == 1){
                    isNewIsland(input,i,j);
                    count+=1;
                }
            }
        }
        return count;
    }

    private static void isNewIsland(int[][] input, int row,int col){
        if(row <0 || col <0 || col >= input[0].length || row >= input.length){
            return ;
        }
        if(input[row][col] == 0){
            return ;
        }
        String indice = row +","+col;
        if(visitedList.contains(indice)){
            return ;
        }
        visitedList.add(indice);
        input[row][col] = 0;
        isNewIsland(input,row+1,col);
        isNewIsland(input,row-1,col);
        isNewIsland(input,row,col+1);
        isNewIsland(input,row,col-1);



    }

    public static void main(String aths[]){

        int input[][] = new int[][] { { 1, 1, 0, 0, 0 },
                                      { 1, 1, 0, 0, 1 },
                                      { 1, 0, 0, 1, 1 }};

        System.out.println("Number of islands is: " + IslandCount.islandCount(input));

    }

}
