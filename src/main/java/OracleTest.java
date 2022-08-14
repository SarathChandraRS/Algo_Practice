import java.util.*;

public class OracleTest {

    public static void main(String args[]){
        int[] input = {-2, 4, -3, 17, -1, 11, -5};
        int length = input.length-1;
        int temp = Integer.MIN_VALUE;
        for(int i=length;i>=0;i--){
            if(i == length){
                temp = input[i];
                input[i] = -1;
                continue;
            }
            if(input[i] > temp){
                int swap = temp;
                temp = input[i];
                input[i] = swap;
            }else {
                input[i] = temp;
            }

        }
        for(int val:input){
            System.out.println(val);
        }


       /* for(int i=0;i<input.length;i++){
            sumOfTwo(input,0-input[i],input[i]);
        }
        System.out.println(result.size());
        for(List<Integer> triplet:result){
            System.out.println(triplet);

        }*/

    }
    static List<List<Integer>> result = new LinkedList<>();

    public static void sumOfTwo(int[] input, int sum, int notInclude){
        Map<Integer,Integer> remainingElements = new HashMap<Integer,Integer>();

        for(int i=0;i<input.length;i++){
            int remaining = sum - input[i];
            remainingElements.put(remaining,input[i]);
        }

        for(int i=0;i<input.length;i++){
            if(remainingElements.containsKey(input[i])){
                List<Integer> triplet = new LinkedList();
                triplet.add(input[i]);
                triplet.add(remainingElements.get(input[i]));
                triplet.add(notInclude);
                result.add(triplet);
            }
        }
    }


}
