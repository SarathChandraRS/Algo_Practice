package array;

public class SubLongSumArray {


    int sum =0;
    int index=0;
    int subArraySize=0;
    int subArrayStart=0;
    int subArrayEnd = 0;
    public void subSumLongArray(int[] a,int k){
        for(int i=0;i<a.length;i++){
            sum = sum +a[i];
            while(k < sum && index < i){
                sum = sum - a[index];
                index++;
            }
            if(subArraySize <= i- index){
                subArraySize = i-index;
                subArrayStart = index;
                subArrayEnd = i;
            }
        }
        System.out.println(subArrayStart+ " "+ subArrayEnd);
    }

    public static void main(String args[]){
        int[] data = {2,4,6,7,0,1,3,2,9,6,1,2,3};
        new SubLongSumArray().subSumLongArray(data,10);
    }


}
