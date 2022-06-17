package algorithms;

import java.util.NoSuchElementException;

public class Heap {

    private int heapSize;
    private int heapLimit = 0;
    private int[] heap;

    public Heap(int heapSize){
        this.heapSize = heapSize;
        this.heap = new int[heapSize];
    }

    public Heap add(int value){
        if(heapLimit == heapSize){
            throw new ArrayIndexOutOfBoundsException();
        }
        heap[heapLimit] = value;
        int child = heapLimit;
        int parent = getParent(child);

        while(parent >= 0 && child > 0){
            if(heap[parent] < heap[child]){
                swapHeapElements(parent, child);
            }else{
                break;
            }
            child = parent;
            parent = getParent(parent);
        }

        heapLimit++;
        return this;
    }

    public int getMaxValue(){
        if(heapSize == 0){
            throw new NoSuchElementException();
        }

        int maxValue = heap[0];
        swapHeapElements(0, heapLimit -1);
        heapLimit--;
        int leftChildIndex = 1;
        int rightChildIndex = 2;
        int root = 0;
        int greatestElementIndex = 0;

        while(leftChildIndex < heapLimit && leftChildIndex < heapSize){
            if( heap[leftChildIndex] > heap[greatestElementIndex]){
               greatestElementIndex = leftChildIndex;
            }

            if(rightChildIndex < heapLimit && rightChildIndex < heapSize && heap[rightChildIndex] > heap[greatestElementIndex]){
                greatestElementIndex = rightChildIndex;
            }

            if(greatestElementIndex == root){
                break;
            }

            swapHeapElements(root, greatestElementIndex);
            root = greatestElementIndex;
            leftChildIndex = 2*root;
            rightChildIndex = 2*root+1;
        }
        return maxValue;
    }

    private int getParent(int index){
        return (int) Math.floor((index-1)/2);
    }

    private void swapHeapElements(int x, int y){
        int temp = heap[x];
        heap[x] = heap[y];
        heap[y] = temp;
    }
}
