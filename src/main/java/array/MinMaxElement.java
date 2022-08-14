package array;

import java.util.ArrayList;
import java.util.List;

public class MinMaxElement {

    public List<Integer> minMax(int[] input){
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<input.length;i++){
            if(input[i] < min){
                min = input[i];
            }
            if(input[i] > max){
                max	= input[i];
            }
        }
        list.add(min);
        list.add(max);
        return list;
    }

}
