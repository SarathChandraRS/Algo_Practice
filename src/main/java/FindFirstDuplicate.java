public class FindFirstDuplicate {

    public static void main(String args[]){
        int[] array = {1,2,3,4,3,4,5,6};
        System.out.println(duplicateIdentifier(array,8));
    }

    public static int duplicateIdentifier(int[] arr, int length){
        for (int i=0; i< arr.length; i++){
            int k= arr[i];
            if (k<0)
            k= k*-1;
            if (arr[k-1] < 0){
                return k;
            }
            arr[k-1] = arr[k-1]*-1;
        }
        return -1;
    }
}
