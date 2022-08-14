package slidingWindow;


import java.util.HashMap;
import java.util.Map;


public class LongestSubStringKDistinct {
    public static int findLength(String str, int k){
        if (str== null || str.length() ==0 || str.length() < k){
            return 0;
        }
        int windowStart =0;
        char[] chars = str.toCharArray();
        Map<Character,Integer> charMap = new HashMap<Character,Integer>();
        int res =0;
        int max = 0;
        for (int windowEnd = 0; windowEnd < chars.length; windowEnd++){
            if (charMap.containsKey(chars[windowEnd])) {
                int count = charMap.get(chars[windowEnd]);
                charMap.put(chars[windowEnd],count++);
            }else
            charMap.put(chars[windowEnd],1);

            while (charMap.size()>k){
                charMap.remove(chars[windowStart]);
                windowStart++;
                res--;
            }
            res++;
            if (max < res){
                max = res;

            }
        }
    return max;
    }

    public static void main(String args[]){
        System.out.println(findLength("araaci",2));
        System.out.println(findLength("araaci",1));
        System.out.println(findLength("cbbebi",3));
    }
}
