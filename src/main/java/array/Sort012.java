package array;

public class Sort012 {

    public static void main(String args[]){
        Sort012 sort = new Sort012();
        int[] inp = {0,1,2,2,1,0,0,0,2,0,1,1};
        sort.sort0s1sFor(inp);
        for(int res : inp){
            System.out.print(res);
            System.out.print(" ");
        }
    }

    public void sort0s1sFor(int[] input){

        int low =0;
        int mid =0;
        int high = input.length -1;
        int temp =-1;
        while(mid <= high){
            switch(input[mid]) {
                case 0: {
                    temp = input[mid];
                    input[mid] = input[low];
                    input[low] = temp;
                    mid++;
                    low++;
                    break;
                }
                case 1:
                    mid++;
                    break;
                case 2: {
                    temp = input[high];
                    input[high] = input[mid];
                    input[mid] = temp;
                    high--;
                    break;
                }
            }
        }
    }

    public void sort0s1s(int[] input){
        int count0 =0;
        int count1 =0;
        int count2 =0;
        int index =0;
        for(int i=0;i<input.length;i++){
            if(input[i] == 0){
                count0++;
            }else if(input[i] == 1){
                count1++;
            }else{
                count2++;
            }
        }
        while(count0 > 0){
            input[index] = 0;
            index++;
            count0--;
        }
        while(count1 > 0){
            input[index] = 1;
            index++;
            count1--;
        }
        while(count2 > 0){
            input[index] = 2;
            index++;
            count2--;
        }

    }
}
