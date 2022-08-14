import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class AmexLRUCache {

    private int capacity;
    Map<String,String> data = new HashMap<>();
    Queue<String> cache = new LinkedList<>();
    public AmexLRUCache(int capacity){
        this.capacity = capacity;
    }

    public String get(String key){
        if (data.containsKey(key)){
            cache.remove(key);
            cache.add(key);
            return data.get(key);
        }
        return null;
    }

    public void put(String key,String value){
        if(data.containsKey(key)){
            cache.remove(key);
            cache.add(key);
            data.put(key,value);
        }else{
            int length = cache.size();
            if(length == capacity){
                String removeKey = cache.poll();
                data.remove(removeKey);
            }
            cache.add(key);
            data.put(key,value);
        }
    }


}
