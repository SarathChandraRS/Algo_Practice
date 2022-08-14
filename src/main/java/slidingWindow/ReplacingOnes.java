package slidingWindow;

public class ReplacingOnes {

    public static int findLength(int[] arr, int k){
        int windowStart = 0;
        int result =0;
        int max=0;
        int zeroCount =0;
        for(int windowEnd = 0; windowEnd < arr.length; windowEnd++){
            if(arr[windowEnd] == 0){
                zeroCount++;
            }
            result++;
            if(zeroCount > k){
                if(arr[windowStart] == 0){
                    zeroCount--;
                }
                windowStart++;
                result--;
            }
            if (result > max){
                max = result;
            }
        }
        return max;
    }

    public static void main(String args[]){
        System.out.println(ReplacingOnes.findLength(new int[]{0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1},2));
        System.out.println(ReplacingOnes.findLength(new int[]{1, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1},3));
    }
}
