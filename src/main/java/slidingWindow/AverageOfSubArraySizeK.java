package slidingWindow;

import java.util.Arrays;

public class AverageOfSubArraySizeK {

    public static double[] findAverage(int[] array, int k){
        double[] result = new double[array.length-k+1];
        int windowStart = 0;
        double sum =0;
        for (int windowEnd = 0;windowEnd< array.length;windowEnd++){
            sum = sum + array[windowEnd];
            if(windowEnd >= k-1){
                result[windowStart] = sum/k;
                sum = sum -array[windowStart];
                windowStart++;
            }

        }

        return result;
    }

    public static void main(String[] args){
        double[] result = findAverage(new int[]{1,3,2,6,-1,4,1,8,2},3);
        System.out.println(Arrays.toString(result));
    }

}
