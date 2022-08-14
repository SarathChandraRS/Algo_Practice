public class Amex {

    /*
    {1,2,3,4,5} k = 1
        5,1,2,3,4

        1,2,3,4,5 k=2
        4,5,1,2,3

        1,2,3,4,5,6 k=4
        3,4,5,6,1,2

        6,5,4,3,2,1

     */

    public static void main(String args[]){
        int[] input = {1,2,3,4,5};
        int k= 6;
        if(k>input.length){
            k = k%input.length;
        }
        if(k>0){

            reverseArray(input,0,input.length-1);
            reverseArray(input,0,0+k-1);
            reverseArray(input,0+k,input.length-1);
        }

        for (int val:input) {
            System.out.print(val + " ");
        }
    }

    private static void reverseArray(int[] input,int start,int end){
        int length = start+end+1;
        for(int i=start;i<length/2;i++){
            int temp = input[length-1-i];
            input[length-1-i] = input[i];
            input[i] = temp;
        }
    }

}
