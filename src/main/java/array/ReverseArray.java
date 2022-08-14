package array;

public class ReverseArray {

    public static void main(String args[]){

        int[] inp = {1,2,3,4,5};
        ReverseArray rev = new ReverseArray();
        rev.reverseRecursive(inp,0,4);
        for(int a:inp){
            System.out.println(a);
        }

    }

    public void reverseArray(int[] input){
        int last_index = input.length-1;
        for(int i=0;i<input.length;i++){
            int temp = input[i];
            input[i] = input[last_index-i];
            input[last_index-i] = temp;
            if(i+1 == last_index-i || i == last_index-i){
                return;
            }
        }
    }

    public void reverseRecursive(int[] input,int start,int end){
        if(start >=end){
            return;
        }
        int temp = input[start];
        input[start] = input[end];
        input[end] = temp;
        reverseRecursive(input,start+1,end-1);

    }
}
