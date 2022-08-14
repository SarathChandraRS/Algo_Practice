package array;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KClosestNumbers{

    public static void main(String atsp[]){
        KClosestNumbers num = new KClosestNumbers();
        int[] input = {1,32,35,2,4,45};
        num.findKclosestFromUnsorted(input,4,33);
    }

    public void findKclosestNumbers(int[] input,int k,int x){
        int l = findClosest(input,0,input.length-1,x);
        int start = l-1;
        int end = l+1;
        int count = 1;
        while(start>=0 && end<=input.length-1 && count < k){
            if(x - input[start] > input[end] -x){
                System.out.println(input[start]);
                start--;
            }else{
                System.out.println(input[end]);
                end++;
            }
            count++;
        }

        while(start>=0 && count < k){
            System.out.println(input[start]);
            start--;
            count++;
        }

        while(end<=input.length-1  && count < k){
            System.out.println(input[end]);
            end++;
            count++;
        }
    }

    private int findClosest(int[] input,int start,int end,int x){
        if(start < end){
            int m = (start+end)/2;
            if(input[m] == x){
                return m;
            }
            if(m>0 && m < input.length && input[m-1]< x && input[m+1] >x){
                return m;
            }
            if(input[m] > x){
                return findClosest(input,start,m-1,x);
            }else {
                return findClosest(input,m+1,end,x);
            }
        }
        return -1;
    }

    public void findKclosestFromUnsorted(int[] input, int k,int x){
        Comparator comparator = new Comparator<Pair>() {
            public int compare(Pair val1, Pair val2) {
                return val2.getValue().compareTo(val1.getValue());
            }
        };
        Queue<Pair> queue = new PriorityQueue<Pair>(comparator);

        for(int i=0;i<k;i++){
            queue.offer(new Pair(input[i],Math.abs(input[i]-x)));
        }
        for(int i=k;i<input.length;i++){
            Pair head = queue.peek();
            if(head.getValue() > Math.abs(input[i] -x)){
                queue.poll();
                queue.offer(new Pair(input[i],Math.abs(input[i]-x)));
            }
        }

        for(Pair res : queue){
            System.out.println(res.key);
        }
    }


}
class Pair{
    public Integer getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Pair(Integer key, Integer value) {
        this.key = key;
        this.value = value;
    }

    Integer key;
    Integer value;



}