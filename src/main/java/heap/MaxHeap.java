package heap;

public class MaxHeap{

    private int[] heapArray;
    private int heapLength = 0;


    public MaxHeap(int length){
        heapArray = new int[length];
    }

    private int parent(int pos){
        return (pos)/2;
    }

    private int leftChild(int pos){
        return (2*pos);
    }

    private int rightChild(int pos){
        return (2*pos) + 1;
    }

    public void add(int value){
        heapLength++;
        heapArray[heapLength] = value;
        int current = heapLength;
        while(heapArray[current] > heapArray[parent(current)]){
            swap(heapLength,parent(heapLength));
            current = parent(current);
        }

    }

    private void swap(int pos, int parentPos){
        int temp = heapArray[pos];
        heapArray[pos] = heapArray[parentPos];
        heapArray[parentPos] = temp;
    }

    private boolean isLeaf(int pos){
        if(pos > (heapLength/2) && pos <= heapLength){
            return true;
        }
        return false;
    }

    private void maxHeapify(int pos){
        if(isLeaf(pos)){
            return;
        }
        if(heapArray[leftChild(pos)] > heapArray[rightChild(pos)]){
            int temp = leftChild(pos);
            swap(temp,pos);
            maxHeapify(temp);
        }
        else {
            int temp = rightChild(pos);
            swap(pos,temp);
            maxHeapify(temp);
        }
    }

    public int extract(int pos){
        int popped = heapArray[1];
        heapArray[1] = heapArray[heapLength--];
        maxHeapify(1);
        return popped;

    }
}
