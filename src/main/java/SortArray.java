import java.util.Arrays;

public class SortArray {

    public static void main(String args[]){
        SortArray sort = new SortArray();
        //int[] sortedArra = sort.insertionSort(new int[]{1, 2, 4, 3, 6, 8, 5});
        int[] sortedArra = new int[]{1, 2, 4, 3, 6, 8, 5,-9,-30};
         sort.quickSort(sortedArra,0,8);
        for (int a : sortedArra) {
            System.out.print(a);
        }
    }

    public int[] bubbleSort(int[] a){
        int n = a.length;
        boolean swap = false;
        for (int i=0; i<n; i++){
            for (int j=0;j<n-i-1;j++){
                if(a[j]>a[j+1]){
                    int temp= a[j];
                    a[j] = a[j+1];
                    a[j+1] =temp;
                    swap = true;
                }

            }
            if(!swap){
                return a;
            }
        }

        return a;

    }

    public int[] selectionSort(int[] a){
        int n= a.length;
        int min;
        for (int i = 0; i< n ; i++){
            min = i;
            for (int j=i+1; j< n ;j++){
                if(a[min] > a[j]){
                   min = j;
                }

            }
            if(min != i){
                int temp= a[i];
                a[i] =a[min];
                a[min]= temp;
            }
        }
        return a;
    }

    public int[] insertionSort(int[] a){
        int n= a.length;
        int j;
        for (int i =1; i< n; i++){
            int key = a[i];
            j = i-1;
            while (j>=0 & key<a[j]){
                a[j+1] = a[j];
                j= j-1;
            }
            a[j+1] = key;
        }

        return a;
    }

    public int[] quickSort(int[] a,int start, int end){
        if(start < end){
            int pivot = partion(a,start,end);
            quickSort(a, start, pivot-1);
            quickSort(a,pivot+1, end);
        }
        return a;
    }

    private int partion(int[] a, int start, int end){

        int pivot = end;
        int index =start;
        int temp;
        for (int i=start;i<end;i++){
            if(a[i] <= a[pivot]){
                temp = a[i];
                a[i] = a[index];
                a[index]= temp;
                index++;
            }
        }
        temp = a[index];
        a[index] = a[pivot];
        a[pivot] = temp;
        return index;
    }


    public void mergeSort(int[] a, int start, int end){
        if (start<end){
            int m= (end+start)/2;
            mergeSort(a,start,m);
            mergeSort(a,m+1,end);
            merge(a,start,end,m);
        }
    }

    public void merge(int[] a,int l,int r, int m){
        int nl= m-l+1;
        int nr= r-m;
        int i=0,j=0,k=l;
        int[] larr = new int[nl];
        int[] rarr = new int[nr];
        for (int g=0; g<nl;g++){
            larr[g]=a[l+g];
        }
        for(int h=0; h<nr;h++){
            rarr[h]=a[m+1+h];
        }
        while(i<nl & j<nr){
            if(larr[i]<rarr[j]){
                a[k]=larr[i];
                i++;
            }else{
                a[k]=rarr[j];
                j++;
            }
            k++;
        }
        while(i<nl){
            a[k]=larr[i];
            i++;
            k++;
        }
        while(r<nr){
            a[k]=rarr[j];
            j++;
            k++;
        }

    }
}
