import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class OracleTest1 {

    public static void main(String args[]){
        int input = 213;
        nextHighest(input);
    }

    public static void nextHighest(Integer a){
        String num = a.toString();
        char[] nums= num.toCharArray();
        for(int j=0;j<nums.length;j++){
            int key = nums.length-j-1;
            for(int i=nums.length-j-1;i>=1;i--){
                if(nums[key] > nums[i-1]){
                    char temp = nums[key];
                    nums[key] = nums[i-1];
                    nums[i-1] = temp;
                    Arrays.sort(nums,i,nums.length);
                    System.out.println(nums);
                    return;
                }
            }
        }


    }

}
