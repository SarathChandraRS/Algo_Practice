import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {

    /*
    Better solution with time complexity of O(1)
        https://stackoverflow.com/questions/23772102/lru-cache-in-java-with-generics-and-o1-operations
     */

    Deque<String> queue;
    Map<String,String> cache;
    long capacity;
    public LRUCache(long capacity){
        this.capacity = capacity;
        queue = new LinkedList();
        cache = new HashMap();
    }

    public void set(String key, String value){
        if(cache.containsKey(key)){
            queue.remove(key);
            cache.remove(key);
        }
        else{
            if(queue.size() >= capacity){
                String lastKey = queue.removeLast();
                cache.remove(lastKey);
            }
        }
        queue.addFirst(key);
        cache.put(key,value);
    }

    public String get(String key){
        if(cache.containsKey(key)){
            String value = cache.get(key);
            queue.remove(key);
            queue.addFirst(key);
            return value;
        }else{
            return null;
        }
    }
}
