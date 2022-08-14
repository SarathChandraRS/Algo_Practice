import java.util.HashMap;
import java.util.Map;

public class SumPairCounts {

    public static void main(String args[]){
        int arr[] = new int[] {1, 1, 1, 1};
        int res = SumPairCounts.countSumPairs(arr,2);
        System.out.println(res);
    }

    public static int countSumPairs(int[] arr, int sum){
        Map<Integer,Integer> occurenceMap = new HashMap<Integer,Integer>();
        int result = 0;
        for (int i=0; i < arr.length; i++){
            if(occurenceMap.containsKey(arr[i])){
                //System.out.println(arr[i]);
                int val = occurenceMap.get(arr[i]);

                occurenceMap.put(arr[i],val+1);
            }
            else{
                occurenceMap.put(arr[i],1);
            }
        }
        for(int j=0; j<arr.length; j++){
            if(occurenceMap.containsKey(sum-arr[j])){
                result = result + occurenceMap.get(sum-arr[j]);
            }
            if (sum - arr[j] == arr[j])
                result--;
        }
       // System.out.println(occurenceMap);
        return result/2;
    }
}
