package slidingWindow;

import java.lang.reflect.Array;
import java.util.Arrays;

public class FindMaxSumSubArrayofSizeK{
    public static int sumSubArrayofSizeK(int[] array,int k){

        // int[] result = new int[k];
        int windowStart =0;
        int sum=0;
        int maximum =0;
        for(int windowEnd =0; windowEnd < array.length;windowEnd++){
            sum = sum + array[windowEnd];
            if(windowEnd >= k-1){
                if (sum > maximum){
                    maximum = sum;
                }
                sum = sum -array[windowStart];
                windowStart++;
            }
        }
        return maximum;
    }

    public static void main(String args[]){
        int max = FindMaxSumSubArrayofSizeK.sumSubArrayofSizeK(new int[]{2,1,5,1,3,2},3);
        System.out.println(max);
        max = FindMaxSumSubArrayofSizeK.sumSubArrayofSizeK(new int[]{2,3,4,1,5},2);
        System.out.println(max);
    }

}

