import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CharOccurances {

    public static void main(String args[]){
        charCount("sarathchandra");
    }

    public static void charCount(String str){
        char[] chars = str.toCharArray();
        Map<Character,Integer> charData = new LinkedHashMap<Character,Integer>();

        for (int i=0;i<chars.length;i++){
            if(charData.containsKey(chars[i])){
                int value = charData.get(chars[i]);
                charData.put(chars[i],value+1);
            }
            else{
                charData.put(chars[i],1);
            }
        }

        System.out.println(charData);
    }

}
