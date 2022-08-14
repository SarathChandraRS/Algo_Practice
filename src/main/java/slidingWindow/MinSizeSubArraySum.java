package slidingWindow;

public class MinSizeSubArraySum {

    public static int findMinSubArray(int[] array, int s){
        int windowStart= 0;
        int sum =0;
        int result=0;
        for (int windowsEnd = 0; windowsEnd < array.length; windowsEnd++){
            sum = sum + array[windowsEnd];
            while(sum >= s){
                if (windowStart==0) {
                    result = windowsEnd - windowStart + 1;
                }
                else if(windowsEnd - windowStart +1 < result){
                    result = windowsEnd - windowStart +1;
                }
                sum = sum -array[windowStart];
                windowStart++;
            }

        }
        return result;
    }

    public static void main(String args[]){
        int result = MinSizeSubArraySum.findMinSubArray(new int[]{2, 1, 5, 2, 3, 2},7);
        System.out.println(result);
        result = MinSizeSubArraySum.findMinSubArray(new int[]{2, 1, 5, 2, 8},7);
        System.out.println(result);
        result = MinSizeSubArraySum.findMinSubArray(new int[]{3, 4, 1, 1, 6},8);
        System.out.println(result);
    }
}
