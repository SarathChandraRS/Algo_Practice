package slidingWindow;

import java.util.HashSet;
import java.util.Set;

public class  NoRepeatSubString {

    public static int findLength(String str){
        if (str == null || str.isEmpty()) {
            return -1;
        }
        int windowStart = 0;
        int result =0;
        int max=0;
        char[] chars = str.toCharArray();
        Set<Character> characterSet = new HashSet<Character>();
        for (int windowEnd = 0; windowEnd < chars.length; windowEnd++){
            result++;
            if (characterSet.contains(chars[windowEnd])){
                result =1;
            }
            characterSet.add(chars[windowEnd]);

            if (max < result){
                max = result;
            }
        }
        return max;
    }

    public static void main(String args[]){
        System.out.println(NoRepeatSubString.findLength("aabccabcdb"));
        System.out.println(NoRepeatSubString.findLength("abbbabc"));
        System.out.println(NoRepeatSubString.findLength("abccde"));
    }
}
