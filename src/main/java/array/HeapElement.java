package array;

import org.jetbrains.annotations.NotNull;

public class HeapElement{

    private boolean isLeaf(int pos){
        if(pos > length/2 || pos >= size){
            return true;
        }
        return false;
    }

    private int parentNode(int pos){
        return pos/2;
    }

    private int leftChild(int pos){
        return (2*pos);
    }


    private int rightChild(int pos){
        return (2*pos)+1;
    }


    private int minHeap(){
        return heap[1];
    }

    private void add(int value){
        length = length+1;
        heap[length] = value;
        int index = length;
        while(heap[parentNode(index)] < value && parentNode(index) >0){
            swap(parentNode(index),index);
            value = heap[parentNode(index)];
            index = parentNode(index);
        }
    }

    private void swap(int parentPos, int pos){
        int temp = heap[parentPos];
        heap[parentPos] = heap[pos];
        heap[pos] = temp;
    }

    private int extract(){
        int val = heap[1];
        heap[1] = heap[length-1];
        length--;
        heapify(1);
        return val;

    }

    private void heapify(int pos){
        if(isLeaf(pos)){
            return;
        }
        if(heap[leftChild(pos)] > heap[rightChild(pos)]){
            swap(leftChild(pos),pos);
            heapify(leftChild(pos));
        }
        else {
            swap(rightChild(pos),pos);
            heapify(rightChild(pos));
        }
    }

    private int[] heap;
    private int length;
    private int size;

    public HeapElement(int length){
        heap = new int[length+1];
        size = length;

    }

    public int smallKthElement(int @NotNull [] input, int k){
       // HeapElement heap = new HeapElement(k);

        for(int i=0; i< input.length;i++){
            if(i>=k){
                int maxVal = minHeap();
                if(maxVal > input[i]){
                    extract();
                    add(input[i]);
                }
            }else{
                add(input[i]);
            }
        }
        return minHeap();
    }

    public static void main(String[] arg){

        int[] input = {1,2,3,5,6,7,-1,-2};
        HeapElement heap = new HeapElement(6);
        System.out.println("Small kth Element"+heap.smallKthElement(input,6));
    }

}

