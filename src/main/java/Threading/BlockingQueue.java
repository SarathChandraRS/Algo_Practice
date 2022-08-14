package Threading;

import java.util.LinkedList;
import java.util.List;

public class BlockingQueue<T> {

    int size = -1;
    List<T> list = new LinkedList<T>();

    public BlockingQueue(int size){

    }

    public void add(T val){
        size++;
        list.add(val);
    }

    public T take(){
        T t = list.get(size);
        size--;
        return t;
    }
}
