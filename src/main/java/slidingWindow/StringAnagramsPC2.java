package slidingWindow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringAnagramsPC2 {
    public static List<Integer> findStringAnagrams(String str, String pattern){
        char[] stringChars = str.toCharArray();
        char[] patternChars = pattern.toCharArray();
        int windowStart =0;
        Map<Character,Integer> patternMap = new HashMap<Character,Integer>();

        for (int i =0; i< patternChars.length;i++){
            if(patternMap.containsKey(patternChars[i])){
                int value = patternMap.get(patternChars[i]);
                value++;
                patternMap.put(patternChars[i],value);
            }else
                patternMap.put(patternChars[i],1);
        }

        for (int windowEnd = 0;windowEnd < stringChars.length; windowEnd++){

            if(patternMap.containsKey(stringChars[windowEnd])){
                patternMap.containsKey(stringChars[windowEnd]);
            }

        }

    return null;
    }

}
